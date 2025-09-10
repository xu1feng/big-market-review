package edu.xyf.domain.activity.service.quota;

import edu.xyf.domain.activity.model.entity.ActivityCountEntity;
import edu.xyf.domain.activity.model.entity.ActivityEntity;
import edu.xyf.domain.activity.model.entity.ActivitySkuEntity;
import edu.xyf.domain.activity.repository.IActivityRepository;
import edu.xyf.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动的支撑类
 * @Date: 2025/9/8 14:37
 */

public class RaffleActivityAccountQuotaSupport {

    protected DefaultActivityChainFactory defaultActivityChainFactory;

    protected IActivityRepository activityRepository;

    public RaffleActivityAccountQuotaSupport(DefaultActivityChainFactory defaultActivityChainFactory, IActivityRepository activityRepository) {
        this.defaultActivityChainFactory = defaultActivityChainFactory;
        this.activityRepository = activityRepository;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }

}
