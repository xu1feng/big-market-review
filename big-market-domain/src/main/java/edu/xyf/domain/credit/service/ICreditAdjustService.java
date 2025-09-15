package edu.xyf.domain.credit.service;

import edu.xyf.domain.credit.model.entity.TradeEntity;

/**
 * @Author: Xuyifeng
 * @Description: 积分调额接口【正逆向，增减积分】
 * @Date: 2025/9/15 15:43
 */

public interface ICreditAdjustService {

    String createOrder(TradeEntity tradeEntity);

}
