package edu.xyf.domain.activity.service.quota;

import com.alibaba.fastjson.JSON;
import edu.xyf.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import edu.xyf.domain.activity.model.entity.*;
import edu.xyf.domain.activity.model.valobj.OrderTradeTypeVO;
import edu.xyf.domain.activity.repository.IActivityRepository;
import edu.xyf.domain.activity.service.IRaffleActivityAccountQuotaService;
import edu.xyf.domain.activity.service.quota.policy.ITradePolicy;
import edu.xyf.domain.activity.service.quota.rule.IActionChain;
import edu.xyf.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;
import edu.xyf.types.enums.ResponseCode;
import edu.xyf.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动抽象类，定义标准的流程
 * @Date: 2025/9/8 11:15
 */
@Slf4j
public abstract class AbstractRaffleActivityAccountQuota extends RaffleActivityAccountQuotaSupport implements IRaffleActivityAccountQuotaService {

    private final Map<String, ITradePolicy> tradePolicyGroup;

    public AbstractRaffleActivityAccountQuota(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory, Map<String, ITradePolicy> tradePolicyGroup) {
        super(activityRepository, defaultActivityChainFactory);
        this.tradePolicyGroup = tradePolicyGroup;
    }

    @Override
    public UnpaidActivityOrderEntity createOrder(SkuRechargeEntity skuRechargeEntity) {
        // 1. 参数校验
        String userId = skuRechargeEntity.getUserId();
        Long sku = skuRechargeEntity.getSku();
        String outBusinessNo = skuRechargeEntity.getOutBusinessNo();
        if (null == sku || StringUtils.isBlank(userId) || StringUtils.isBlank(outBusinessNo)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2. 查询未支付订单「一个月以内的未支付订单」
        UnpaidActivityOrderEntity unpaidCreditOrder =  activityRepository.queryUnpaidActivityOrder(skuRechargeEntity);
        if (null != unpaidCreditOrder) return unpaidCreditOrder;

        // 3. 查询基础信息「sku、活动、次数」
        ActivitySkuEntity activitySkuEntity = queryActivitySku(sku);
        ActivityEntity activityEntity = queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        ActivityCountEntity activityCountEntity = queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());

        // 4. 账户额度 【交易属性的兑换，需要校验额度账户】
        if (OrderTradeTypeVO.credit_pay_trade.equals(skuRechargeEntity.getOrderTradeType())){
            BigDecimal availableAmount = activityRepository.queryUserCreditAccountAmount(userId);
            if (availableAmount.compareTo(activitySkuEntity.getProductAmount()) < 0) {
                throw new AppException(ResponseCode.USER_CREDIT_ACCOUNT_NO_AVAILABLE_AMOUNT.getCode(), ResponseCode.USER_CREDIT_ACCOUNT_NO_AVAILABLE_AMOUNT.getInfo());
            }
        }

        // 5. 活动动作规则校验 「过滤失败则直接抛异常」- 责任链扣减sku库存
        IActionChain actionChain = defaultActivityChainFactory.openActionChain();
        actionChain.action(activitySkuEntity, activityEntity, activityCountEntity);

        // 6. 构建订单聚合对象
        CreateQuotaOrderAggregate createOrderAggregate = buildOrderAggregate(skuRechargeEntity, activitySkuEntity, activityEntity, activityCountEntity);

        // 7. 交易策略 - 【积分兑换，支付类订单】【返利无支付交易订单，直接充值到账】【订单状态变更交易类型策略】
        ITradePolicy tradePolicy = tradePolicyGroup.get(skuRechargeEntity.getOrderTradeType().getCode());
        tradePolicy.trade(createOrderAggregate);

        // 8. 返回订单信息
        ActivityOrderEntity activityOrderEntity = createOrderAggregate.getActivityOrderEntity();
        return UnpaidActivityOrderEntity.builder()
                .userId(userId)
                .orderId(activityOrderEntity.getOrderId())
                .outBusinessNo(activityOrderEntity.getOutBusinessNo())
                .payAmount(activityOrderEntity.getPayAmount())
                .build();
    }

    protected abstract CreateQuotaOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}
