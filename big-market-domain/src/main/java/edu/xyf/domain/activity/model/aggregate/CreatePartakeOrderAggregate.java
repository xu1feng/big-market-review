package edu.xyf.domain.activity.model.aggregate;

import edu.xyf.domain.activity.model.entity.ActivityAccountDayEntity;
import edu.xyf.domain.activity.model.entity.ActivityAccountEntity;
import edu.xyf.domain.activity.model.entity.ActivityAccountMonthEntity;
import edu.xyf.domain.activity.model.entity.UserRaffleOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 参与活动订单聚合对象
 * @Date: 2025/9/10 14:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartakeOrderAggregate {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 账户总额度
     */
    private ActivityAccountEntity activityAccountEntity;

    /**
     * 是否存在月账户
     */
    private boolean isExistAccountMonth = true;

    /**
     * 账户月额度
     */
    private ActivityAccountMonthEntity activityAccountMonthEntity;

    /**
     * 是否存在日账户
     */
    private boolean isExistAccountDay = true;

    /**
     * 账户日额度
     */
    private ActivityAccountDayEntity activityAccountDayEntity;

    /**
     * 抽奖单实体
     */
    private UserRaffleOrderEntity userRaffleOrderEntity;

}
