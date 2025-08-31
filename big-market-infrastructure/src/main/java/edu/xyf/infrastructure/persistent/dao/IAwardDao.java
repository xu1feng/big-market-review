package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 抽奖奖品DAO
 * @Date: 2025/8/31 17:05
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}
