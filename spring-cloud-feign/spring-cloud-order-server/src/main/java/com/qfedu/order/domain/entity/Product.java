package com.qfedu.order.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Data

public class Product {
    /**
     * id
     */

    private Integer id;

    /**
     * 商品名
     */

    private String productName;

    /**
     * 商品旧价格
     */

    private BigDecimal oldPrice;

    /**
     * 商品新价格
     */

    private BigDecimal newPrice;

    /**
     * 库存
     */

    private Integer productStock;

    /**
     * 商品图片
     */

    private String productImg;


    private Integer version;


    private String productDes;


    private String productAtt;

}