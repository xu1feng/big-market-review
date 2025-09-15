package edu.xyf.domain.award.service;

import edu.xyf.domain.award.event.SendAwardMessageEvent;
import edu.xyf.domain.award.model.aggregate.UserAwardRecordAggregate;
import edu.xyf.domain.award.model.entity.DistributeAwardEntity;
import edu.xyf.domain.award.model.entity.TaskEntity;
import edu.xyf.domain.award.model.entity.UserAwardRecordEntity;
import edu.xyf.domain.award.model.valobj.TaskStateVO;
import edu.xyf.domain.award.repository.IAwardRepository;
import edu.xyf.domain.award.service.distribute.IDistributeAward;
import edu.xyf.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/10 19:03
 */
@Slf4j
@Service
public class AwardService implements IAwardService {

    private final IAwardRepository awardRepository;
    private final SendAwardMessageEvent sendAwardMessageEvent;

    private final Map<String, IDistributeAward> distributeAwardMap;

    public AwardService(Map<String, IDistributeAward> distributeAwardMap, SendAwardMessageEvent sendAwardMessageEvent, IAwardRepository awardRepository) {
        this.distributeAwardMap = distributeAwardMap;
        this.sendAwardMessageEvent = sendAwardMessageEvent;
        this.awardRepository = awardRepository;
    }

    @Override
    public void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity) {
        // 构建消息对象
        SendAwardMessageEvent.SendAwardMessage sendAwardMessage = new SendAwardMessageEvent.SendAwardMessage();
        sendAwardMessage.setUserId(userAwardRecordEntity.getUserId());
        sendAwardMessage.setOrderId(userAwardRecordEntity.getOrderId());
        sendAwardMessage.setAwardId(userAwardRecordEntity.getAwardId());
        sendAwardMessage.setAwardTitle(userAwardRecordEntity.getAwardTitle());
        sendAwardMessage.setAwardConfig(userAwardRecordEntity.getAwardConfig());

        BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> sendAwardMessageEventMessage = sendAwardMessageEvent.buildEventMessage(sendAwardMessage);

        // 构建任务对象
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userAwardRecordEntity.getUserId());
        taskEntity.setTopic(sendAwardMessageEvent.topic());
        taskEntity.setMessageId(sendAwardMessageEventMessage.getId());
        taskEntity.setMessage(sendAwardMessageEventMessage);
        taskEntity.setState(TaskStateVO.create);

        // 构建聚合对象
        UserAwardRecordAggregate userAwardRecordAggregate = UserAwardRecordAggregate.builder()
                .taskEntity(taskEntity)
                .userAwardRecordEntity(userAwardRecordEntity)
                .build();

        // 存储聚合对象 - 一个事务下，用户的中奖记录
        awardRepository.saveUserAwardRecord(userAwardRecordAggregate);
        log.info("中奖记录保存完成 userId:{} orderId:{}", userAwardRecordEntity.getUserId(), userAwardRecordEntity.getOrderId());
    }

    @Override
    public void distributeAward(DistributeAwardEntity distributeAwardEntity) {
        // 奖品Key
        String awardKey = awardRepository.queryAwardKey(distributeAwardEntity.getAwardId());
        if (null == awardKey) {
            log.error("分发奖品，奖品ID 不存在。awardKey:{}", awardKey);
            return;
        }

        IDistributeAward distributeAward = distributeAwardMap.get(awardKey);
        if (null == distributeAward) {
            log.error("分发奖品，对应的服务不存在。awardKey: {}", awardKey);
            // todo 后续完善全部奖品后开启异常
//            throw new RuntimeException("分发奖品，奖品 " + awardKey + " 对应的服务不存在");
            return;
        }

        // 发动奖品
        distributeAward.giveOutPrizes(distributeAwardEntity);
    }

}