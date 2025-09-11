package edu.xyf.trigger.api;

import edu.xyf.trigger.api.dto.ActivityDrawRequestDTO;
import edu.xyf.trigger.api.dto.ActivityDrawResponseDTO;
import edu.xyf.types.model.Response;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动服务
 * @Date: 2025/9/11 14:40
 */

public interface IRaffleActivityService {

    /**
     * 活动装配，数据预热缓存
     * @param activityId 活动ID
     * @return 装配结果
     */
    Response<Boolean> armory(Long activityId);

    /**
     * 活动抽奖接口
     * @param requset 请求对象
     * @return 返回结果
     */
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);

}
