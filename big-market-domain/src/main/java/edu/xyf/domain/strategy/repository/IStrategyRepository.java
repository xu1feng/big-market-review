package edu.xyf.domain.strategy.repository;

import edu.xyf.domain.strategy.model.entity.StrategyAwardEntity;
import edu.xyf.domain.strategy.model.entity.StrategyEntity;
import edu.xyf.domain.strategy.model.entity.StrategyRuleEntity;
import edu.xyf.domain.strategy.model.valobj.RuleTreeVO;
import edu.xyf.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 策略仓储接口
 * @Date: 2025/9/1 14:22
 */

public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTables(String key, Integer rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);

}
