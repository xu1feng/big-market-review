package edu.xyf.test.infrastructure;

import com.alibaba.fastjson.JSON;
import edu.xyf.infrastructure.persistent.dao.IAwardDao;
import edu.xyf.infrastructure.persistent.po.Award;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 奖品持久化单元测试
 * @Date: 2025/8/31 17:33
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList() {
        List<Award> awards = awardDao.queryAwardList();
        log.info("测试结果: {}", JSON.toJSONString(awards));
    }

}
