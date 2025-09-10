package edu.xyf.domain.activity.model.entity;

import lombok.Data;

/**
 * @Author: Xuyifeng
 * @Description: 参与抽奖活动实体对象
 * @Date: 2025/9/10 14:08
 */
@Data
public class PartakeRaffleActivityEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
