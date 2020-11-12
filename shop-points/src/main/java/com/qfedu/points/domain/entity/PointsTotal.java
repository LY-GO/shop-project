package com.qfedu.points.domain.entity;

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
@TableName(value = "t_points_total")
public class PointsTotal {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 总积分
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 消费积分
     */
    @TableField(value = "total_con")
    private Integer totalCon;

    /**
     * 获得总积分
     */
    @TableField(value = "total_get")
    private Integer totalGet;

    /**
     * 会员ID
     */
    @TableField(value = "member_id")
    private Integer memberId;

    public static final String COL_ID = "id";

    public static final String COL_TOTAL = "total";

    public static final String COL_TOTAL_CON = "total_con";

    public static final String COL_TOTAL_GET = "total_get";

    public static final String COL_MEMBER_ID = "member_id";
}