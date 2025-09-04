package edu.xyf.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 策略奖品库存Key标识值对象
 * @Date: 2025/9/4 16:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardStockKeyVO {

    private Long strategyId;
    private Integer awardId;

}
