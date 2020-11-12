package com.qfedu.rest.domain.request;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/3
 */
@Data
public class MemberRequest {

    private String nickname;


    private String memberGender;


    private Date birthday;


    private String memberPhone;


    private String memberEmail;


    private String password;

    private String username;
}
