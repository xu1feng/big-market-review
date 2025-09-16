package edu.xyf.domain.activity.service;

import edu.xyf.domain.activity.model.entity.SkuProductEntity;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 17:10
 */

public interface IRaffleActivitySkuProductService {

    List<SkuProductEntity> querySkuProductEntityListByActivityId(Long activityId);

}
