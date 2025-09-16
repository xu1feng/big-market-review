package edu.xyf.domain.credit.model.aggregate;

import edu.xyf.domain.credit.event.CreditAdjustSuccessMessageEvent;
import edu.xyf.domain.credit.model.entity.CreditAccountEntity;
import edu.xyf.domain.credit.model.entity.CreditOrderEntity;
import edu.xyf.domain.credit.model.entity.TaskEntity;
import edu.xyf.domain.credit.model.valobj.TradeNameVO;
import edu.xyf.domain.credit.model.valobj.TradeTypeVO;
import edu.xyf.domain.rebate.model.valobj.TaskStateVO;
import edu.xyf.types.event.BaseEvent;
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
    private TaskEntity taskEntity;

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

    public static TaskEntity createTaskEntity(String userId, String topic, String messageId, BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> message) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userId);
        taskEntity.setTopic(topic);
        taskEntity.setMessageId(messageId);
        taskEntity.setMessage(message);
        taskEntity.setState(TaskStateVO.create);
        return taskEntity;
    }

}
