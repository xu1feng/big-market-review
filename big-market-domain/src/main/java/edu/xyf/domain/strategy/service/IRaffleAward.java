package edu.xyf.domain.strategy.service;

import edu.xyf.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 策略奖品接口
 * @Date: 2025/9/6 14:44
 */

public interface IRaffleAward {

    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

}
