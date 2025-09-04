package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略奖品明细配置DAO
 * @Date: 2025/8/31 17:06
 */
@Mapper
public interface IStrategyAwardDao {

    List<StrategyAward> queryStrategyAwardList();

    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);

    String queryStrategyAwardRuleModels(StrategyAward strategyAward);

    void updateStrategyAwardStock(StrategyAward strategyAward);

}
