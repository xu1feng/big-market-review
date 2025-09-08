package edu.xyf.domain.activity.repository;

import edu.xyf.domain.activity.model.entity.ActivityCountEntity;
import edu.xyf.domain.activity.model.entity.ActivityEntity;
import edu.xyf.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @Author: Xuyifeng
 * @Description: 活动仓储接口
 * @Date: 2025/9/8 11:18
 */

public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

}
