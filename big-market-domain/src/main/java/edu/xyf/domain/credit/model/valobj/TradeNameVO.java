package edu.xyf.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Xuyifeng
 * @Description: 交易名称枚举值
 * @Date: 2025/9/15 15:46
 */
@Getter
@AllArgsConstructor
public enum TradeNameVO {

    REBATE("行为返利"),
    CONVERT_SKU("兑换抽奖"),
    ;

    private final String name;

}
