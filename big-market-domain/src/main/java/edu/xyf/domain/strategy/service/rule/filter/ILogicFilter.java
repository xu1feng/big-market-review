package edu.xyf.domain.strategy.service.rule.filter;

import edu.xyf.domain.strategy.model.entity.RuleActionEntity;
import edu.xyf.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖规则逻辑过滤接口
 * @Date: 2025/9/2 14:13
 */

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}
