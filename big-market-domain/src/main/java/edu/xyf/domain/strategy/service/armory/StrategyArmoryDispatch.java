package edu.xyf.domain.strategy.service.armory;

import edu.xyf.domain.strategy.model.entity.StrategyAwardEntity;
import edu.xyf.domain.strategy.model.entity.StrategyEntity;
import edu.xyf.domain.strategy.model.entity.StrategyRuleEntity;
import edu.xyf.domain.strategy.repository.IStrategyRepository;
import edu.xyf.types.enums.ResponseCode;
import edu.xyf.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @Author: Xuyifeng
 * @Description: 策略装配库（兵工厂），负责初始化策略计算
 * @Date: 2025/9/1 14:21
 */
@Slf4j
@Service
public class StrategyArmoryDispatch implements IStrategyArmory, IStrategyDispatch {

    @Resource
    private IStrategyRepository repository;

    @Override
    public boolean assembleLotteryStrategy(Long strategyId) {
        // 1. 查询策略配置 - 获取该策略下所有的奖品配置列表
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrategyAwardList(strategyId);
        // 2. 构建基础的概率查找表，存储到 Redis 中，键为 strategyId
        assembleLotteryStrategy(String.valueOf(strategyId), strategyAwardEntities);

        // 3. 查询策略实体，检查是否存在权重规则配置
        StrategyEntity strategyEntity = repository.queryStrategyEntityByStrategyId(strategyId);
        // 获取策略中配置的权重规则名称，如 "rule_weight"
        String ruleWeight = strategyEntity.getRuleWeight();
        // 如果没有配置权重规则，则直接返回，只使用基础策略
        if (null == ruleWeight) {
            return true;
        }

        // 4. 如果配置了权重规则，则查询具体的权重规则内容
        StrategyRuleEntity strategyRuleEntity = repository.queryStrategyRule(strategyId, ruleWeight);
        // 如果权重规则不存在，则抛出异常
        if (null == strategyRuleEntity) {
            throw new AppException(ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getCode(), ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getInfo());
        }

        // 5. 解析权重规则值，获取权重配置映射表
        // ruleWeightValueMap 格式示例: {"4000:101,102": [101, 102], "5000:101,102,103": [101, 102, 103]}
        Map<String, List<Integer>> ruleWeightValueMap = strategyRuleEntity.getRuleWeightValues();
        // 获取所有权重配置的键集合，如 ["4000:101,102", "5000:101,102,103"]
        Set<String> keys = ruleWeightValueMap.keySet();

        // 6. 遍历每个权重配置，为每个配置构建独立的概率查找表
        for (String key : keys) {
            // 获取当前权重配置允许的奖品ID列表，如 [101, 102]
            List<Integer> ruleWeightValues = ruleWeightValueMap.get(key);
            // 创建原始奖品列表的副本，避免修改原始数据
            ArrayList<StrategyAwardEntity> strategyAwardEntitiesClone = new ArrayList<>(strategyAwardEntities);
            // 从奖品列表中移除不在当前权重配置中的奖品，只保留允许的奖品
            strategyAwardEntitiesClone.removeIf(entity -> !ruleWeightValues.contains(entity.getAwardId()));
            // 为当前权重配置构建独立的概率查找表
            // 存储到 Redis 中的键格式为: strategyId_key，例如: "10001_4000:101,102"
            assembleLotteryStrategy(String.valueOf(strategyId).concat("_").concat(key), strategyAwardEntitiesClone);
        }

        return true;
    }


    private void assembleLotteryStrategy(String key, List<StrategyAwardEntity> strategyAwardEntities) {
        // 1. 获取最小概率值
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // 2. 获取概率值总和
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 3. 用 1 % 0.0001 获取概率范围，百分位、千分位、万分位
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        // 4. 生成策略奖品概率查找表「这里指需要在list集合中，存放上对应的奖品占位即可，占位越多等于概率越高」
        ArrayList<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAwardEntity : strategyAwardEntities) {
            Integer awardId = strategyAwardEntity.getAwardId();
            BigDecimal awardRate = strategyAwardEntity.getAwardRate();
            // 计算出每个概率值需要存放到查找表的数量，循环填充
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }
        }

        // 5. 对存储的奖品进行乱序操作
        Collections.shuffle(strategyAwardSearchRateTables);

        // 6. 生成出Map集合，key值，对应的就是后续的概率值。通过概率来获得对应的奖品ID
        HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables = new HashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTables.put(i, strategyAwardSearchRateTables.get(i));
        }

        // 7. 存储到 Redis
        repository.storeStrategyAwardSearchRateTables(key, shuffleStrategyAwardSearchRateTables.size(), shuffleStrategyAwardSearchRateTables);
    }

    /**
     * 负责实际抽奖过程，从 Redis 中获取查找表并进行抽奖
     *
     * @param strategyId
     * @return
     */
    @Override
    public Integer getRandomAwardId(Long strategyId) {
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        int rateRange = repository.getRateRange(strategyId);
        // 通过生成的随机值，获取概率值奖品查找表的结果
        return repository.getStrategyAwardAssemble(String.valueOf(strategyId), new SecureRandom().nextInt(rateRange));
    }

    @Override
    public Integer getRandomAwardId(Long strategyId, String ruleWeightValue) {
        String key = String.valueOf(strategyId).concat("_").concat(ruleWeightValue);
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        int rateRange = repository.getRateRange(key);
        // 通过生成的随机值，获取概率值奖品查找表的结果
        return repository.getStrategyAwardAssemble(key, new SecureRandom().nextInt(rateRange));
    }

}
