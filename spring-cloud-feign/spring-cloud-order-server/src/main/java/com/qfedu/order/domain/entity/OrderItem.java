package com.qfedu.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Data
@TableName(value = "tb_order_item")
public class OrderItem {
    /**
     * 主键
     */
    @TableId(value = "order_item_id", type = IdType.AUTO)
    private Integer orderItemId;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 会员Id
     */
    @TableField(value = "member_id")
    private Integer memberId;

    /**
     * 商品图片
     */
    @TableField(value = "product_pic")
    private String productPic;

    /**
     * 商品的名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品的购买价格
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 购买的数量
     */
    @TableField(value = "product_quantity")
    private Integer productQuantity;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_ORDER_NO = "order_no";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_PRODUCT_PIC = "product_pic";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";

    public static final String COL_PRODUCT_QUANTITY = "product_quantity";

    public static final String COL_STATUS = "status";
}