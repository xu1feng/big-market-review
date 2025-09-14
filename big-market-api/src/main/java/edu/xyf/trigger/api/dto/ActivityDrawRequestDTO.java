package edu.xyf.trigger.api.dto;

import lombok.Data;

/**
 * @Author: Xuyifeng
 * @Description: 活动抽奖请求对象
 * @Date: 2025/9/11 14:42
 */
@Data
public class ActivityDrawRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
