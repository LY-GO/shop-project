package com.qfedu.order.domain.entity;

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
 * @Data:2020/8/6
 */
@Data
@TableName(value = "tb_order")
public class Order {
    /**
     * 主键
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;

    /**
     * 订单状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 总价
     */
    @TableField(value = "total")
    private BigDecimal total;

    /**
     * 会员ID
     */
    @TableField(value = "member_id")
    private Integer memberId;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_NO = "order_no";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_STATUS = "status";

    public static final String COL_TOTAL = "total";

    public static final String COL_MEMBER_ID = "member_id";
}