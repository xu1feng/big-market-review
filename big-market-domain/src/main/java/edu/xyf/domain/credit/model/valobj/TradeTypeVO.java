package edu.xyf.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Xuyifeng
 * @Description: 交易类型枚举值
 * @Date: 2025/9/15 15:45
 */
@Getter
@AllArgsConstructor
public enum TradeTypeVO {

    FORWARD("forward", "正向交易，+ 积分"),
    REVERSE("reverse", "逆向交易，- 积分"),
    ;

    private final String code;
    private final String info;

}
