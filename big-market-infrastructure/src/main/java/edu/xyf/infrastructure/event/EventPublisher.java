package edu.xyf.infrastructure.event;

import com.alibaba.fastjson.JSON;
import edu.xyf.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description: 消息发送
 * @Date: 2025/9/9 13:56
 */
@Slf4j
@Component
public class EventPublisher {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void publish(String topic, BaseEvent.EventMessage<?> eventMessage) {
        try {
            String messageJson = JSON.toJSONString(eventMessage);
            rabbitTemplate.convertAndSend(topic, messageJson);
            log.info("发送MQ消息 topic:{} message:{}", topic, messageJson);
        } catch (Exception e) {
            log.error("发生MQ消息失败 topic:{} message:{}", topic, JSON.toJSONString(eventMessage), e);
            throw e;
        }
    }

    public void publish(String topic, String eventMessageJSON) {
        try {
            rabbitTemplate.convertAndSend(topic, eventMessageJSON);
            log.info("发送MQ消息 topic:{} message:{}", topic, eventMessageJSON);
        } catch (Exception e) {
            log.error("发送MQ消息失败 topic:{} message:{}", topic, eventMessageJSON, e);
            throw e;
        }
    }

}
