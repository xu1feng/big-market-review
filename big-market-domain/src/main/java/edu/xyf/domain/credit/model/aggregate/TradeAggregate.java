package edu.xyf.domain.credit.model.aggregate;

import edu.xyf.domain.credit.model.entity.CreditAccountEntity;
import edu.xyf.domain.credit.model.entity.CreditOrderEntity;
import edu.xyf.domain.credit.model.valobj.TradeNameVO;
import edu.xyf.domain.credit.model.valobj.TradeTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/15 15:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeAggregate {

    private String userId;
    private CreditAccountEntity creditAccountEntity;
    private CreditOrderEntity creditOrderEntity;

    public static CreditAccountEntity buildCreditAccountEntity(String userId, BigDecimal adjustAmount) {
        return CreditAccountEntity.builder()
                .userId(userId)
                .adjustAmount(adjustAmount)
                .build();
    }

    public static CreditOrderEntity buildCreditOrderEntity(String userId, TradeNameVO tradeName, TradeTypeVO tradeType, BigDecimal tradeAmount, String outBusinessNo) {
        return CreditOrderEntity.builder()
                .userId(userId)
                .orderId(RandomStringUtils.randomNumeric(12))
                .tradeName(tradeName)
                .tradeType(tradeType)
                .tradeAmount(tradeAmount)
                .outBusinessNo(outBusinessNo)
                .build();
    }

}
