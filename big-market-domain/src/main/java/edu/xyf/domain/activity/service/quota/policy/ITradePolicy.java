package edu.xyf.domain.activity.service.quota.policy;

import edu.xyf.domain.activity.model.aggregate.CreateQuotaOrderAggregate;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 14:36
 */

public interface ITradePolicy {

    void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate);

}
