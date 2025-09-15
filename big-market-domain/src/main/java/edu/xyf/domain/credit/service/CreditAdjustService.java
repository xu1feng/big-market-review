package edu.xyf.domain.credit.service;

import edu.xyf.domain.credit.model.aggregate.TradeAggregate;
import edu.xyf.domain.credit.model.entity.CreditAccountEntity;
import edu.xyf.domain.credit.model.entity.CreditOrderEntity;
import edu.xyf.domain.credit.model.entity.TradeEntity;
import edu.xyf.domain.credit.repository.ICreditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/15 15:56
 */
@Slf4j
@Service
public class CreditAdjustService implements ICreditAdjustService {

    @Resource
    private ICreditRepository creditRepository;

    @Override
    public String createOrder(TradeEntity tradeEntity) {
        log.info("增加账户积分额度开始 userId:{} tradeName:{} amount:{}", tradeEntity.getUserId(), tradeEntity.getTradeName(), tradeEntity.getAmount());
        // 1. 创建账户积分实体
        CreditAccountEntity creditAccountEntity = TradeAggregate.buildCreditAccountEntity(tradeEntity.getUserId(), tradeEntity.getAmount());

        // 2. 创建账户订单实体
        CreditOrderEntity creditOrderEntity = TradeAggregate.buildCreditOrderEntity(
                tradeEntity.getUserId(),
                tradeEntity.getTradeName(),
                tradeEntity.getTradeType(),
                tradeEntity.getAmount(),
                tradeEntity.getOutBusinessNo()
        );

        // 3. 构建交易聚合对象
        TradeAggregate tradeAggregate = TradeAggregate.builder()
                .userId(tradeEntity.getUserId())
                .creditAccountEntity(creditAccountEntity)
                .creditOrderEntity(creditOrderEntity)
                .build();

        creditRepository.saveUserCreditTradeOrder(tradeAggregate);

        return creditOrderEntity.getOrderId();
    }

}
