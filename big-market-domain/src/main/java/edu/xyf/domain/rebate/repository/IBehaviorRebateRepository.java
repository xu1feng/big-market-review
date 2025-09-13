package edu.xyf.domain.rebate.repository;

import edu.xyf.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import edu.xyf.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import edu.xyf.domain.rebate.model.valobj.BehaviorTypeVO;
import edu.xyf.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 行为返利服务仓储接口
 * @Date: 2025/9/12 15:08
 */

public interface IBehaviorRebateRepository {

    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);

}
