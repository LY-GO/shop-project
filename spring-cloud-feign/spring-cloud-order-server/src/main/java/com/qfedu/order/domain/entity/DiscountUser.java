package com.qfedu.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/9
 */
@Data
@TableName(value = "t_discount_user")
public class DiscountUser {
    /**
     * 用户优惠券id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员id
     */
    @TableField(value = "member_id")
    private Integer memberId;

    /**
     * 获得数量
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 获得时间
     */
    @TableField(value = "get_time")
    private Date getTime;

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

    @TableField(value = "discount_kind")
    private String discountKind;

    @TableField(value = "discount_money")
    private BigDecimal discountMoney;

    @TableField(value = "discount_des")
    private Integer discountDes;

    @TableField(value = "discount_limit")
    private Integer discountLimit;

    /**
     * 满多少有折扣
     */
    @TableField(value = "discount_total")
    private Integer discountTotal;

    public static final String COL_ID = "id";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_COUNT = "count";

    public static final String COL_GET_TIME = "get_time";

    public static final String COL_PAST_TIME = "past_time";

    public static final String COL_STATUS = "status";

    public static final String COL_DISCOUNT_KIND = "discount_kind";

    public static final String COL_DISCOUNT_MONEY = "discount_money";

    public static final String COL_DISCOUNT_DES = "discount_des";

    public static final String COL_DISCOUNT_LIMIT = "discount_limit";

    public static final String COL_DISCOUNT_TOTAL = "discount_total";
}