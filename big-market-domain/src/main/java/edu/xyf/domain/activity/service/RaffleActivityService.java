package edu.xyf.domain.activity.service;

import edu.xyf.domain.activity.model.aggregate.CreateOrderAggregate;
import edu.xyf.domain.activity.model.entity.*;
import edu.xyf.domain.activity.model.valobj.ActivitySkuStockKeyVO;
import edu.xyf.domain.activity.model.valobj.OrderStateVO;
import edu.xyf.domain.activity.repository.IActivityRepository;
import edu.xyf.domain.activity.service.rule.factory.DefaultActivityChainFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动服务
 * @Date: 2025/9/8 11:31
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity implements ISkuStock {

    public RaffleActivityService(DefaultActivityChainFactory defaultActivityChainFactory, IActivityRepository activityRepository) {
        super(defaultActivityChainFactory, activityRepository);
    }

    @Override
    protected void doSaveOrder(CreateOrderAggregate createOrderAggregate) {
        activityRepository.doSaveOrder(createOrderAggregate);
    }

    @Override
    protected CreateOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        // 1. 订单实体对象
        ActivityOrderEntity activityOrderEntity = ActivityOrderEntity.builder()
                .userId(skuRechargeEntity.getUserId())
                .sku(skuRechargeEntity.getSku())
                .activityId(activityEntity.getActivityId())
                .activityName(activityEntity.getActivityName())
                .strategyId(activityEntity.getStrategyId())
                .orderId(RandomStringUtils.randomNumeric(12))
                .orderTime(new Date())
                .totalCount(activityCountEntity.getTotalCount())
                .dayCount(activityCountEntity.getDayCount())
                .monthCount(activityCountEntity.getMonthCount())
                .state(OrderStateVO.completed)
                .outBusinessNo(skuRechargeEntity.getOutBusinessNo())
                .build();

        // 2. 构建聚合对象
        return CreateOrderAggregate.builder()
                .userId(skuRechargeEntity.getUserId())
                .activityId(activityEntity.getActivityId())
                .totalCount(activityCountEntity.getTotalCount())
                .dayCount(activityCountEntity.getDayCount())
                .monthCount(activityCountEntity.getMonthCount())
                .activityOrderEntity(activityOrderEntity)
                .build();
    }

    @Override
    public ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException {
        return activityRepository.takeQueueValue();
    }

    @Override
    public void clearQueueValue() {
        activityRepository.clearQueueValue();
    }

    @Override
    public void updateActivitySkuStock(Long sku) {
        activityRepository.updateActivitySkuStock(sku);
    }

    @Override
    public void clearActivitySkuStock(Long sku) {
        activityRepository.clearActivitySkuStock(sku);
    }

}
