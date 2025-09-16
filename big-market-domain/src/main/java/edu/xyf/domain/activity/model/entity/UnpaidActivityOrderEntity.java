package edu.xyf.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 16:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnpaidActivityOrderEntity {

    private String userId;
    private String orderId;
    private String outBusinessNo;
    private BigDecimal payAmount;

}
