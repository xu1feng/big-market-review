package edu.xyf.domain.strategy.service.armory;

/**
 * @Author: Xuyifeng
 * @Description: 策略装配库（兵工厂），负责初始化策略计算
 * @Date: 2025/9/1 14:20
 */

public interface IStrategyArmory {

    void assembleLotteryStrategy(Long strategyId);

    Integer getRandomAwardId(Long strategyId);

}
