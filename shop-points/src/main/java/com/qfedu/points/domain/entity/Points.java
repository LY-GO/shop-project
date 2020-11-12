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
@TableName(value = "t_points")
public class Points {
    /**
     * 积分id
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

    public static final String COL_ID = "id";

    public static final String COL_POINTS_KIND = "points_kind";

    public static final String COL_POINTS_VALUE = "points_value";
}