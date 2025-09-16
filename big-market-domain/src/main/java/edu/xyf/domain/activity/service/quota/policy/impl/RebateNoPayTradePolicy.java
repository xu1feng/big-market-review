package edu.xyf.domain.activity.service.quota.policy.impl;

import edu.xyf.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import edu.xyf.domain.activity.model.valobj.OrderStateVO;
import edu.xyf.domain.activity.repository.IActivityRepository;
import edu.xyf.domain.activity.service.quota.policy.ITradePolicy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 14:38
 */
@Service("rebate_no_pay_trade")
public class RebateNoPayTradePolicy implements ITradePolicy {

    private final IActivityRepository activityRepository;

    public RebateNoPayTradePolicy(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate) {
        createQuotaOrderAggregate.setOrderState(OrderStateVO.completed);
        createQuotaOrderAggregate.getActivityOrderEntity().setPayAmount(BigDecimal.ZERO);
        activityRepository.doSaveNoPayOrder(createQuotaOrderAggregate);
    }

}
