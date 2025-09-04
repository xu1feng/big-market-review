package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Xuyifeng
 * @Description: 规则树DAO
 * @Date: 2025/9/4 14:19
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}
