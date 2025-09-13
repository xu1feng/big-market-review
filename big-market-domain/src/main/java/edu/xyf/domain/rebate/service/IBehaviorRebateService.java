package edu.xyf.domain.rebate.service;

import edu.xyf.domain.rebate.model.entity.BehaviorEntity;
import edu.xyf.domain.rebate.model.entity.BehaviorRebateOrderEntity;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 行为返利服务接口
 * @Date: 2025/9/12 15:03
 */

public interface IBehaviorRebateService {

    List<String> createOrder(BehaviorEntity behaviorEntity);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);

}
