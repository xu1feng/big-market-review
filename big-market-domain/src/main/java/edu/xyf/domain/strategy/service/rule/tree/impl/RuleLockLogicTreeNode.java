package edu.xyf.domain.strategy.service.rule.tree.impl;

import edu.xyf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import edu.xyf.domain.strategy.service.rule.tree.ILogicTreeNode;
import edu.xyf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyifeng
 * @Description: 次数锁节点
 * @Date: 2025/9/3 15:57
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
