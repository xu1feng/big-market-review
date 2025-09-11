package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 规则树节点DAO
 * @Date: 2025/9/4 14:20
 */
@Mapper
public interface IRuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);

    List<RuleTreeNode> queryRuleLocks(String[] treeIds);

}
