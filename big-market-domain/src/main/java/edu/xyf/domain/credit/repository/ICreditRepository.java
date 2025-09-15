package edu.xyf.domain.credit.repository;

import edu.xyf.domain.credit.model.aggregate.TradeAggregate;

/**
 * @Author: Xuyifeng
 * @Description: 用户积分仓储
 * @Date: 2025/9/15 15:41
 */

public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

}
