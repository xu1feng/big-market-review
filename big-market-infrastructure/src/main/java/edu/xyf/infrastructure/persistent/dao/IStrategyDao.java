package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略DAO
 * @Date: 2025/8/31 17:06
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);

}
