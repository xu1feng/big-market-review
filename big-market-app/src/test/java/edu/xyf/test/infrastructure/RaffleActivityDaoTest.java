package edu.xyf.test.infrastructure;

import com.alibaba.fastjson.JSON;
import edu.xyf.infrastructure.persistent.dao.IRaffleActivityDao;
import edu.xyf.infrastructure.persistent.po.RaffleActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖活动配置Dao测试
 * @Date: 2025/9/7 17:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityDaoTest {

    @Resource
    private IRaffleActivityDao raffleActivityDao;

    @Test
    public void test_queryRaffleActivityByActivityId() {
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301L);
        log.info("测试结果: {}", JSON.toJSONString(raffleActivity));
    }

}
