package edu.xyf.domain.activity.service.quota.rule.factory;

import edu.xyf.domain.activity.service.quota.rule.IActionChain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description: 责任链工厂
 * @Date: 2025/9/8 14:49
 */
@Service
public class DefaultActivityChainFactory {

    private final IActionChain actionChain;

    public DefaultActivityChainFactory(Map<String, IActionChain> actionChainGroup) {
        actionChain = actionChainGroup.get(ActionModel.activity_base_action.code);
        actionChain.appendNext(actionChainGroup.get(ActionModel.activity_sku_stock_action.code));
    }

    public IActionChain openActionChain() {
        return this.actionChain;
    }

    @Getter
    @AllArgsConstructor
    public enum ActionModel {

        activity_base_action("activity_base_action", "活动的时间、状态校验"),
        activity_sku_stock_action("activity_sku_stock_action", "活动sku库存"),
        ;

        private final String code;
        private final String info;
    }

}
