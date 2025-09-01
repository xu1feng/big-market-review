package edu.xyf.test.domain;

import edu.xyf.domain.strategy.service.armory.IStrategyArmory;
import edu.xyf.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/1 14:55
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IStrategyDispatch strategyDispatch;

    @Before
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("策略装配结果：{}", success);
    }

    @Test
    public void test_getRandomAwardId() {
        log.info("测试结果：{} - 奖品ID值", strategyDispatch.getRandomAwardId(100001L));
    }

    @Test
    public void test_getRandomAwardId_ruleWeightValue() {
        log.info("测试结果：{} - 消耗4000积分 策略配置", strategyDispatch.getRandomAwardId(100001L, "4000:102,103,104,105"));
        log.info("测试结果：{} - 消耗5000积分 策略配置", strategyDispatch.getRandomAwardId(100001L, "5000:102,103,104,105,106,107"));
        log.info("测试结果：{} - 消耗6000积分 策略配置", strategyDispatch.getRandomAwardId(100001L, "6000:102,103,104,105,106,107,108,109"));
    }

}
