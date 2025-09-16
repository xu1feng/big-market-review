package edu.xyf.domain.activity.model.entity;

import edu.xyf.domain.activity.model.valobj.OrderTradeTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 活动商品充值实体对象
 * @Date: 2025/9/8 14:29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuRechargeEntity {

    /** 用户ID */
    private String userId;
    /** 商品SKU - activity + activity count */
    private Long sku;
    /** 幂等业务单号，外部谁充值谁透传，这样来保证幂等（多次调用也能确保结果唯一，不会多次充值）。 */
    private String outBusinessNo;
    /** 订单交易类型 */
    private OrderTradeTypeVO orderTradeType = OrderTradeTypeVO.rebate_no_pay_trade;

}
