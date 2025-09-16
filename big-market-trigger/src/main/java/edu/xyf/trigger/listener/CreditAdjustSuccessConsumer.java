package edu.xyf.trigger.listener;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import edu.xyf.domain.activity.model.entity.DeliveryOrderEntity;
import edu.xyf.domain.activity.service.IRaffleActivityAccountQuotaService;
import edu.xyf.domain.credit.event.CreditAdjustSuccessMessageEvent;
import edu.xyf.types.enums.ResponseCode;
import edu.xyf.types.event.BaseEvent;
import edu.xyf.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 15:43
 */
@Slf4j
@Component
public class CreditAdjustSuccessConsumer {

    @Value("${spring.rabbitmq.topic.credit_adjust_success}")
    private String topic;

    @Resource
    private IRaffleActivityAccountQuotaService raffleActivityAccountQuotaService;

    @RabbitListener(queuesToDeclare = @Queue(value = "${spring.rabbitmq.topic.credit_adjust_success}"))
    public void listener(String message) {
        try {
            log.info("监听积分账户调整成功消息，进行交易商品发货 topic:{} message:{}", topic, message);
            BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> eventMessage = JSON.parseObject(message, new TypeReference<BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage>>() {
            }.getType());
            CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage creditAdjustSuccessMessage = eventMessage.getData();

            // 积分发货
            DeliveryOrderEntity deliveryOrderEntity = new DeliveryOrderEntity();
            deliveryOrderEntity.setUserId(creditAdjustSuccessMessage.getUserId());
            deliveryOrderEntity.setOutBusinessNo(creditAdjustSuccessMessage.getOutBusinessNo());
            raffleActivityAccountQuotaService.updateOrder(deliveryOrderEntity);
        } catch (AppException e) {
            if (ResponseCode.INDEX_DUP.getCode().equals(e.getCode())) {
                log.warn("监听积分账户调整异常消息，进行交易商品发货 topic:{} message:{}", topic, message, e);
                return;
            }
            throw e;
        } catch (Exception e) {
            log.warn("监听积分账户调整失败消息，进行交易商品发货 topic:{} message:{}", topic, message, e);
            throw e;
        }
    }

}
