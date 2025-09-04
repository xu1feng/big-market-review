package edu.xyf.domain.strategy.service.armory;

/**
 * @Author: Xuyifeng
 * @Description: 策略抽奖的调度
 * @Date: 2025/9/1 15:58
 */

public interface IStrategyDispatch {

    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    Boolean subtractionAwardStock(Long strategyId, Integer awardId);

}
