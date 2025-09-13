package edu.xyf.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/13 15:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleStrategyRuleWeightResponseDTO {

    private Integer ruleWeightCount;

    private Integer userActivityAccountTotalUseCount;

    private List<?> strategyAwards;

    @Data
    public static class StrategyAward {
        private Integer awardId;
        private String awardTitle;
    }

}
