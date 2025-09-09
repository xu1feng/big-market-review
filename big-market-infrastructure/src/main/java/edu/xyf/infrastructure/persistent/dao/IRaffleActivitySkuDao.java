package edu.xyf.infrastructure.persistent.dao;

import edu.xyf.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Xuyifeng
 * @Description: 商品sku dao
 * @Date: 2025/9/8 10:49
 */
@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);

}
