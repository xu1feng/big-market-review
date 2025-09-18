package edu.xyf.infrastructure.dao;

import edu.xyf.infrastructure.dao.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动表Dao
 * @Date: 2025/9/7 17:04
 */
@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    Long queryStrategyIdByActivityId(Long activityId);

    Long queryActivityIdByStrategyId(Long strategyId);

}
