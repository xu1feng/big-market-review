package edu.xyf.domain.strategy.service.rule.tree;

import edu.xyf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @Author: Xuyifeng
 * @Description: 规则树接口
 * @Date: 2025/9/3 15:55
 */

public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);

}
