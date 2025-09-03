package edu.xyf.domain.strategy.service.rule.chain.impl;

import edu.xyf.domain.strategy.service.armory.IStrategyDispatch;
import edu.xyf.domain.strategy.service.rule.chain.AbstractLogicChain;
import edu.xyf.domain.strategy.service.rule.chain.ILogicChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description: 兜底方法，默认的责任链「作为最后一个链」
 * @Date: 2025/9/3 14:15
 */
@Slf4j
@Component("default")
public class DefaultLogicChain extends AbstractLogicChain {

    @Resource
    protected IStrategyDispatch strategyDispatch;

    @Override
    public Integer logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
        return awardId;
    }

    @Override
    protected String ruleModel() {
        return "default";
    }

}