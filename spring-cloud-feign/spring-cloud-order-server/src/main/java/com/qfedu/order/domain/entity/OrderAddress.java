package com.qfedu.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/6
 */

/**
 * 订单地址信息
 */
@Data
@TableName(value = "tb_order_address")
public class OrderAddress {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "address")
    private String address;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "order_id")
    private Integer orderId;

    public static final String COL_ID = "id";

    public static final String COL_ADDRESS = "address";

    public static final String COL_PHONE = "phone";

    public static final String COL_ORDER_ID = "order_id";
}