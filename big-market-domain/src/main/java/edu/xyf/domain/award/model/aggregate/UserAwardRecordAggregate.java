package edu.xyf.domain.award.model.aggregate;

import edu.xyf.domain.award.model.entity.TaskEntity;
import edu.xyf.domain.award.model.entity.UserAwardRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 用户中奖记录聚合对象【聚合代表一个事务操作】
 * @Date: 2025/9/10 19:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAwardRecordAggregate {

    private UserAwardRecordEntity userAwardRecordEntity;
    private TaskEntity taskEntity;

}
