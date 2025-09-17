package edu.xyf.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/9/16 16:37
 */
@Data
public class SkuProductShopCartRequestDTO implements Serializable {

    private String userId;
    private Long sku;

}
