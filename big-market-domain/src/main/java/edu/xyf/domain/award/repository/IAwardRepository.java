package edu.xyf.domain.award.repository;

import edu.xyf.domain.award.model.aggregate.GiveOutPrizesAggregate;
import edu.xyf.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/10 19:00
 */

public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

    String queryAwardConfig(Integer awardId);

    void saveGiveOutPrizesAggregate(GiveOutPrizesAggregate giveOutPrizesAggregate);

    String queryAwardKey(Integer awardId);

}
