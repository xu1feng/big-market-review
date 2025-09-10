package edu.xyf.domain.task.service;

import edu.xyf.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 消息任务服务接口
 * @Date: 2025/9/10 19:36
 */

public interface ITaskService {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}
