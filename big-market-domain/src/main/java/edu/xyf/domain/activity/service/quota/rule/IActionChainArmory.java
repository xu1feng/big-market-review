package edu.xyf.domain.activity.service.quota.rule;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖动作责任链装配
 * @Date: 2025/9/8 14:43
 */

public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
