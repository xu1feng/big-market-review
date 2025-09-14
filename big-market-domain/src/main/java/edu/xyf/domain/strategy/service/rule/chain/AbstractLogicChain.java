package edu.xyf.domain.strategy.service.rule.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略责任链，判断走那种抽奖策略。如：默认抽象、权重抽奖、黑名单抽奖
 * @Date: 2025/9/3 14:13
 */
@Slf4j
public abstract class AbstractLogicChain implements ILogicChain{

    private ILogicChain next;

    @Override
    public ILogicChain next() {
        return next;
    }

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    protected abstract String ruleModel();

}