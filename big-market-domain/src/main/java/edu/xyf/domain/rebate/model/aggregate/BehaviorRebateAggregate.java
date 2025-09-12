package edu.xyf.domain.rebate.model.aggregate;

import edu.xyf.domain.rebate.model.entity.BehaviorEntity;
import edu.xyf.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import edu.xyf.domain.rebate.model.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 行为返利聚合对象
 * @Date: 2025/9/12 15:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorRebateAggregate {

    private String userId;
    private BehaviorRebateOrderEntity behaviorRebateOrderEntity;
    private TaskEntity taskEntity;

}
