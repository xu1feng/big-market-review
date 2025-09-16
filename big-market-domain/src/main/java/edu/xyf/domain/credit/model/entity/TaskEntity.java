package edu.xyf.domain.credit.model.entity;

import edu.xyf.domain.credit.event.CreditAdjustSuccessMessageEvent;
import edu.xyf.domain.rebate.model.valobj.TaskStateVO;
import edu.xyf.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 任务实体对象
 * @Date: 2025/9/16 15:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    private String userId;
    private String topic;
    private String messageId;
    private BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> message;
    private TaskStateVO state;

}
