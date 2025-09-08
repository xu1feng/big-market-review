package edu.xyf.domain.activity.service;

import edu.xyf.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动服务
 * @Date: 2025/9/8 11:31
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity {

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

}
