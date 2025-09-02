package edu.xyf.domain.strategy.service;

import edu.xyf.domain.strategy.model.entity.RaffleAwardEntity;
import edu.xyf.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略接口
 * @Date: 2025/9/2 14:08
 */

public interface IRaffleStrategy {

    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);

}
