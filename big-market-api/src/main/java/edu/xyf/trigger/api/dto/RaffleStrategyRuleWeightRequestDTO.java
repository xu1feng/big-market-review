package edu.xyf.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/13 15:11
 */
@Data
public class RaffleStrategyRuleWeightRequestDTO implements Serializable {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}
