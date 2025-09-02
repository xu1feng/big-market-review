package edu.xyf.domain.strategy.model.entity;

import edu.xyf.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * @Author: Xuyifeng
 * @Description: 规则动作实体 - 抽奖前、中、后
 * @Date: 2025/9/2 14:17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity <T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;

    static public class RaffleEntity {

    }

    // 抽奖前
    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RaffleBeforeEntity extends RaffleEntity {
        /**
         * 策略ID
         */
        private Long strategyId;

        /**
         * 权重值Key；用于抽奖时可以选择权重抽奖
         */
        private String ruleWeightValueKey;

        /**
         * 奖品ID
         */
        private Integer awardId;
    }

    // 抽奖前
    static public class RaffleCenterEntity extends RaffleEntity {

    }

    // 抽奖中
    static public class RaffleAfterEntity extends RaffleEntity {

    }

}
