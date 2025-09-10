package edu.xyf.domain.award.service;

import edu.xyf.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @Author: Xuyifeng
 * @Description: 奖品服务接口
 * @Date: 2025/9/10 17:02
 */

public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

}
