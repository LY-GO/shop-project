package com.qfedu.rest.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import lombok.Data;

@Data
@TableName(value = "t_member")
public class Member {
    /**
     * 会员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;


    /**
     * 性别
     */
    @TableField(value = "member_gender")
    private String memberGender;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 电话
     */
    @TableField(value = "member_phone")
    private String memberPhone;

    /**
     * 邮箱
     */
    @TableField(value = "member_email")
    private String memberEmail;

    @TableField(value = "password")
    private String password;

    /**
     * 0激活1停用
     */
    @TableField(value = "status")
    @TableLogic
    private Integer status;

    /**
     * '用户名'
     */
    @TableField(value = "username")
    private String username;

    public static final String COL_ID = "id";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_MEMBER_NAME = "member_name";

    public static final String COL_MEMBER_GENDER = "member_gender";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_MEMBER_PHONE = "member_phone";

    public static final String COL_MEMBER_EMAIL = "member_email";

    public static final String COL_PASSWORD = "password";

    public static final String COL_STATUS = "status";

    public static final String COL_USERNAME = "username";
}