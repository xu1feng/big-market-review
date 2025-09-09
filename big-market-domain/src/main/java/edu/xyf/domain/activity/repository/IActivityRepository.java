package edu.xyf.domain.activity.repository;

import edu.xyf.domain.activity.model.aggregate.CreateOrderAggregate;
import edu.xyf.domain.activity.model.entity.ActivityCountEntity;
import edu.xyf.domain.activity.model.entity.ActivityEntity;
import edu.xyf.domain.activity.model.entity.ActivitySkuEntity;
import edu.xyf.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;

/**
 * @Author: Xuyifeng
 * @Description: 活动仓储接口
 * @Date: 2025/9/8 11:18
 */

public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateOrderAggregate createOrderAggregate);

    void cacheActivitySkuStockCount(String cacheKey, Integer stockCount);

    boolean subtractionActivitySkuStock(Long sku, String cacheKey, Date endDateTime);

    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);

    ActivitySkuStockKeyVO takeQueueValue();

    void clearQueueValue();

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);

}
