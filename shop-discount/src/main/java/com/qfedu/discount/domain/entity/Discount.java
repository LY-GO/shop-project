package com.qfedu.discount.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/9
 */
@Data
@TableName(value = "t_discount")
public class Discount {
    /**
     * 优惠券id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺名
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * 优惠券种类
     */
    @TableField(value = "discount_kind")
    private String discountKind;

    /**
     * 折扣金额
     */
    @TableField(value = "discount_money")
    private BigDecimal discountMoney;

    /**
     * 优惠券类型:1折扣卷/2兑换券/3红包
     */
    @TableField(value = "discount_des")
    private Integer discountDes;

    /**
     * 优惠券发放数量
     */
    @TableField(value = "discount_stock")
    private Integer discountStock;

    /**
     * 优惠券使用范围:0全店/其他特定商品
     */
    @TableField(value = "discount_limit")
    private Integer discountLimit;

    /**
     * 发放时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 过期时间
     */
    @TableField(value = "past_time")
    private Date pastTime;

    /**
     * 1未过期0过期
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 满多少有折扣
     */
    @TableField(value = "discount_total")
    private Integer discountTotal;

    public static final String COL_ID = "id";

    public static final String COL_SHOP_NAME = "shop_name";

    public static final String COL_DISCOUNT_KIND = "discount_kind";

    public static final String COL_DISCOUNT_MONEY = "discount_money";

    public static final String COL_DISCOUNT_DES = "discount_des";

    public static final String COL_DISCOUNT_STOCK = "discount_stock";

    public static final String COL_DISCOUNT_LIMIT = "discount_limit";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PAST_TIME = "past_time";

    public static final String COL_STATUS = "status";

    public static final String COL_DISCOUNT_TOTAL = "discount_total";
}