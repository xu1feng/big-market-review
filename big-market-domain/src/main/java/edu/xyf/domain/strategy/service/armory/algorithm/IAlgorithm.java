package edu.xyf.domain.strategy.service.armory.algorithm;

import edu.xyf.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/22 19:21
 */

public interface IAlgorithm {

    void armoryAlgorithm(String key, List<StrategyAwardEntity> strategyAwardEntities, BigDecimal rateRange);

    Integer dispatchAlgorithm(String key);

}
