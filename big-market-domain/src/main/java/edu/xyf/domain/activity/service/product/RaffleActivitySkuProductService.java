package edu.xyf.domain.activity.service.product;

import edu.xyf.domain.activity.model.entity.SkuProductEntity;
import edu.xyf.domain.activity.repository.IActivityRepository;
import edu.xyf.domain.activity.service.IRaffleActivitySkuProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 17:13
 */
@Service
public class RaffleActivitySkuProductService implements IRaffleActivitySkuProductService {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public List<SkuProductEntity> querySkuProductEntityListByActivityId(Long activityId) {
        return activityRepository.querySkuProductEntityListByActivityId(activityId);
    }

}
