package edu.xyf.domain.activity.service.rule;

import edu.xyf.domain.activity.model.entity.ActivityCountEntity;
import edu.xyf.domain.activity.model.entity.ActivityEntity;
import edu.xyf.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @Author: Xuyifeng
 * @Description: 下单规则过滤接口
 * @Date: 2025/9/8 14:42
 */

public interface IActionChain extends IActionChainArmory {

    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}
