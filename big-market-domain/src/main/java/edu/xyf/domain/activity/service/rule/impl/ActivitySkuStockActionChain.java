package edu.xyf.domain.activity.service.rule.impl;

import edu.xyf.domain.activity.model.entity.ActivityCountEntity;
import edu.xyf.domain.activity.model.entity.ActivityEntity;
import edu.xyf.domain.activity.model.entity.ActivitySkuEntity;
import edu.xyf.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyifeng
 * @Description: 商品库存规则节点
 * @Date: 2025/9/8 14:47
 */
@Slf4j
@Component("activity_sku_stock_action")
public class ActivitySkuStockActionChain extends AbstractActionChain {

    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商品库存处理【校验&扣减】开始。");
        return true;
    }

}
