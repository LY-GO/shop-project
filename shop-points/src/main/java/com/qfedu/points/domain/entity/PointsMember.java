package com.qfedu.points.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.Data;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Data
@TableName(value = "t_points_member")
public class PointsMember {
    /**
     * 会员积分id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 积分类型
     */
    @TableField(value = "points_kind")
    private String pointsKind;

    /**
     * 积分值
     */
    @TableField(value = "points_value")
    private Integer pointsValue;

    /**
     * 获得时间
     */
    @TableField(value = "get_time")
    private Date getTime;

    /**
     * 会员id
     */
    @TableField(value = "member_id")
    private Integer memberId;

    /**
     * 0表示获取1表示消耗
     */
    @TableField(value = "status")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_POINTS_KIND = "points_kind";

    public static final String COL_POINTS_VALUE = "points_value";

    public static final String COL_GET_TIME = "get_time";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_STATUS = "status";
}