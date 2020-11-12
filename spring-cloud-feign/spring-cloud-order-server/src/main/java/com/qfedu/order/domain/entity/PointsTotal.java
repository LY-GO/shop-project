package com.qfedu.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Data

public class PointsTotal {
    /**
     * id
     */

    private Integer id;

    /**
     * 总积分
     */

    private Integer total;

    /**
     * 消费积分
     */

    private Integer totalCon;

    /**
     * 获得总积分
     */

    private Integer totalGet;

    /**
     * 会员ID
     */

    private Integer memberId;


}