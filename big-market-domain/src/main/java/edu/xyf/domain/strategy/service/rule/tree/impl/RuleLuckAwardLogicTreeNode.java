package edu.xyf.domain.strategy.service.rule.tree.impl;

import edu.xyf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import edu.xyf.domain.strategy.service.rule.tree.ILogicTreeNode;
import edu.xyf.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyifeng
 * @Description: 兜底奖励节点
 * @Date: 2025/9/3 15:58
 */
@Slf4j
@Component("rule_luck_award")
public class RuleLuckAwardLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardData(DefaultTreeFactory.StrategyAwardData.builder()
                        .awardId(101)
                        .awardRuleValue("1,100")
                        .build())
                .build();
    }
}
