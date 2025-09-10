package edu.xyf.domain.task.repository;

import edu.xyf.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 任务服务仓储接口
 * @Date: 2025/9/10 19:39
 */

public interface ITaskRepository {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}
