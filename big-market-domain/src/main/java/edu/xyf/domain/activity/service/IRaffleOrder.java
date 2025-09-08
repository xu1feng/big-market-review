package edu.xyf.domain.activity.service;

import edu.xyf.domain.activity.model.entity.ActivityOrderEntity;
import edu.xyf.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动订单接口
 * @Date: 2025/9/8 11:12
 */

public interface IRaffleOrder {

    /**
     * 以sku创建抽奖活动订单，获得参与抽奖资格（可消耗次数）
     * @param activityShopCartEntity 活动sku实体，通过sku领取活动
     * @return 活动参与记录实体
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);

}
