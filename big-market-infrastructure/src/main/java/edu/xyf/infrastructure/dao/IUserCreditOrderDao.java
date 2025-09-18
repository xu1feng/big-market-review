package edu.xyf.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import edu.xyf.infrastructure.dao.po.UserCreditOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Xuyifeng
 * @Description: 用户积分流水单 DAO
 * @Date: 2025/9/15 15:34
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserCreditOrderDao {

    void insert(UserCreditOrder userCreditOrderReq);

}
