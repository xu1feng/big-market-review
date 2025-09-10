package edu.xyf.domain.activity.service.quota.rule;

/**
 * @Author: Xuyifeng
 * @Description: 下单规则责任链抽象类
 * @Date: 2025/9/8 14:44
 */

public abstract class AbstractActionChain implements IActionChain {

    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
