package edu.xyf.domain.award.service.distribute;

import edu.xyf.domain.award.model.entity.DistributeAwardEntity;

/**
 * @Author: Xuyifeng
 * @Description: 分发奖品接口
 * @Date: 2025/9/15 13:35
 */

public interface IDistributeAward {

    void giveOutPrizes(DistributeAwardEntity distributeAwardEntity);

}
