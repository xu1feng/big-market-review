package edu.xyf.domain.rebate.model.entity;

import edu.xyf.domain.rebate.model.valobj.BehaviorTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 行为实体
 * @Date: 2025/9/12 15:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorEntity {

    private String userId;
    private BehaviorTypeVO behaviorTypeVO;
    private String outBusinessNo;

}
