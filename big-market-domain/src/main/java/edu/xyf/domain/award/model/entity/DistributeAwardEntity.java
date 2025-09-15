package edu.xyf.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 分发奖品实体对象
 * @Date: 2025/9/15 13:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistributeAwardEntity {

    private String userId;
    private String orderId;
    private Integer awardId;
    private String awardConfig;

}
