package edu.xyf.domain.strategy.service.rule.chain;

/**
 * @Author: Xuyifeng
 * @Description: 责任链装配接口
 * @Date: 2025/9/3 14:46
 */

public interface ILogicChainArmory {

    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();

}
