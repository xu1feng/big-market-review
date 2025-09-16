package edu.xyf.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Xuyifeng
 * @Description: 订单状态枚举值对象（用于描述对象属性的值，如枚举，不影响数据库操作的对象，无生命周期）
 * @Date: 2025/9/8 11:05
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {

    completed("completed", "完成"),
    wait_pay("wait_pay", "待支付"),
    ;

    private final String code;
    private final String desc;

}
