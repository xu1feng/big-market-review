package edu.xyf.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Xuyifeng
 * @Description: 用户积分奖品实体对象
 * @Date: 2025/9/15 13:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreditAwardEntity {

    private String userId;
    private BigDecimal creditAmount;

}
