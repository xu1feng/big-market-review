package edu.xyf.domain.strategy.service.rule.tree.factory.engine;

import edu.xyf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @Author: Xuyifeng
 * @Description: 规则数组合接口
 * @Date: 2025/9/3 16:02
 */

public interface IDecisionTreeEngine {

    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);

}
