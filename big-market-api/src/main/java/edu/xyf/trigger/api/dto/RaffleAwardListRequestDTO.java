package edu.xyf.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖奖品列表，请求对象
 * @Date: 2025/9/6 14:19
 */
@Data
public class RaffleAwardListRequestDTO implements Serializable {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}
