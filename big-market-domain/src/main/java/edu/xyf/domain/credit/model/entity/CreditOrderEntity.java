package edu.xyf.domain.credit.model.entity;

import edu.xyf.domain.credit.model.valobj.TradeNameVO;
import edu.xyf.domain.credit.model.valobj.TradeTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Xuyifeng
 * @Description: 积分订单实体
 * @Date: 2025/9/15 15:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditOrderEntity {

    /** 用户ID */
    private String userId;
    /** 订单ID */
    private String orderId;
    /** 交易名称 */
    private TradeNameVO tradeName;
    /** 交易类型；交易类型；forward-正向、reverse-逆向 */
    private TradeTypeVO tradeType;
    /** 交易金额 */
    private BigDecimal tradeAmount;
    /** 业务仿重ID - 外部透传。返利、行为等唯一标识 */
    private String outBusinessNo;

}
