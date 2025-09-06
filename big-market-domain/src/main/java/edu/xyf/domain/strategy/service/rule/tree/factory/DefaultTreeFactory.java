package edu.xyf.domain.strategy.service.rule.tree.factory;

import edu.xyf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import edu.xyf.domain.strategy.model.valobj.RuleTreeVO;
import edu.xyf.domain.strategy.service.rule.tree.ILogicTreeNode;
import edu.xyf.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import edu.xyf.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description: 规则树工厂
 * @Date: 2025/9/3 16:00
 */
@Service
public class DefaultTreeFactory {

    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        private Integer awardId;
        /**
         * 抽奖奖品规则
         */
        private String awardRuleValue;
    }

}
