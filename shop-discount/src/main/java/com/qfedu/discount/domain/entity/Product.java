package com.qfedu.discount.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Data
@TableName(value = "t_product")
public class Product {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品旧价格
     */
    @TableField(value = "old_price")
    private Long oldPrice;

    /**
     * 商品新价格
     */
    @TableField(value = "new_price")
    private BigDecimal newPrice;

    /**
     * 库存
     */
    @TableField(value = "product_stock")
    private Long productStock;

    /**
     * 商品图片
     */
    @TableField(value = "product_img")
    private String productImg;
    @Version
    @TableField(value = "version")
    private Integer version;

    @TableField(value = "product_des")
    private String productDes;

    @TableField(value = "product_att")
    private String productAtt;

    public static final String COL_ID = "id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_OLD_PRICE = "old_price";

    public static final String COL_NEW_PRICE = "new_price";

    public static final String COL_PRODUCT_STOCK = "product_stock";

    public static final String COL_PRODUCT_IMG = "product_img";

    public static final String COL_VERSION = "version";

    public static final String COL_PRODUCT_DES = "product_des";

    public static final String COL_PRODUCT_ATT = "product_att";
}