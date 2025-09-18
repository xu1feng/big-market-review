package edu.xyf.infrastructure.dao;

import edu.xyf.infrastructure.dao.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略规则DAO
 * @Date: 2025/8/31 17:06
 */
@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);

}
