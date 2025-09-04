package edu.xyf.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖策略规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @Date: 2025/9/2 16:35
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

}
