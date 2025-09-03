package edu.xyf.domain.strategy.service.rule.chain;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略规则责任链接口
 * @Date: 2025/9/3 14:09
 */

public interface ILogicChain extends ILogicChainArmory {

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);

}
