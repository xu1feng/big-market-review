package edu.xyf.trigger.api.dto;

import lombok.Data;

/**
 * @Author: Xuyifeng
 * @Description: 用户活动账户请求对象
 * @Date: 2025/9/13 14:38
 */
@Data
public class UserActivityAccountRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
