package edu.xyf.infrastructure.dao;

import edu.xyf.infrastructure.dao.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动次数配置表Dao
 * @Date: 2025/9/7 17:03
 */
@Mapper
public interface IRaffleActivityCountDao {

    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);

}
