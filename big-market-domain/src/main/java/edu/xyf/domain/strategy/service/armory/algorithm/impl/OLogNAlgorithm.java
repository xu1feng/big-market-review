package edu.xyf.domain.strategy.service.armory.algorithm.impl;

import edu.xyf.domain.strategy.model.entity.StrategyAwardEntity;
import edu.xyf.domain.strategy.service.armory.algorithm.AbstractAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/22 19:26
 */
@Component("oLogNAlgorithm")
public class OLogNAlgorithm extends AbstractAlgorithm {

    @Override
    public void armoryAlgorithm(String key, List<StrategyAwardEntity> strategyAwardEntities, BigDecimal rateRange) {
        int from = 1;
        int to = 0;
        Map<Map<Integer, Integer>, Integer> table = new HashMap<>();
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            to += rateRange.multiply(awardRate).intValue();
            Map<Integer, Integer> ft = new HashMap<>();
            ft.put(from, to);
            table.put(ft, awardId);
            from = to + 1;
        }

        repository.storeStrategyAwardSearchRateTable(key, to, table);
    }

    @Override
    public Integer dispatchAlgorithm(String key) {
        int rateRange = repository.getRateRange(key);
        Map<Map<String, Integer>, Integer> table = repository.getMap(key);
        if (table.size() <= 8) {
            return forSearch(rateRange, table);
        } else if (table.size() <= 16) {
            return binarySearch(rateRange, table);
        } else {
            return threadSearch(rateRange, table);
        }
    }

    private Integer threadSearch(int rateRange, Map<Map<String, Integer>, Integer> table) {
        return forSearch(rateRange, table);
    }

    private Integer binarySearch(int rateRange, Map<Map<String, Integer>, Integer> table) {
        return forSearch(rateRange, table);
    }

    private Integer forSearch(int rateRange, Map<Map<String, Integer>, Integer> table) {
        Integer awardId = null;
        for (Map.Entry<Map<String, Integer>, Integer> entry : table.entrySet()) {
            Map<String, Integer> rangeMap = entry.getKey();
            for (Map.Entry<String, Integer> range : rangeMap.entrySet()) {
                int start = Integer.parseInt(range.getKey());
                int end = range.getValue();
                if (rateRange >= start && rateRange <= end) {
                    awardId = entry.getValue();
                    break;
                }
            }
            if (awardId != null) {
                break;
            }
        }
        return awardId;
    }

}
