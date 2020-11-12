package com.qfedu.rest.controller;

import com.qfedu.rest.common.RequestCode;
import com.qfedu.rest.common.RequestEntity;
import com.qfedu.rest.domain.request.MemberRequest;
import com.qfedu.rest.exception.ControllerException;
import com.qfedu.rest.domain.Member;
import com.qfedu.rest.domain.vo.MemberVo;
import com.qfedu.rest.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@Validated
@RequestMapping("/login")
@Api("用户中心")
public class LoginController {
    @Resource
    LoginServiceImpl loginService;

    @ApiOperation("登录功能")

    @PostMapping("/userlogin")
    public RequestEntity<Member> login(@ApiParam("关键字") @Pattern(regexp = "[a-zA-Z]\\w{7,16}", message = "数据格式错误") String keyWord, @ApiParam("密码") @Pattern(regexp = "[a-zA-Z]\\w{7,16}", message = "数据格式错误") String password) {
        MemberVo memberVo = loginService.login(keyWord, password);
        if (memberVo != null) {
            return RequestEntity.success(RequestCode.SUCCESS, memberVo);
        } else {
            throw new ControllerException(RequestCode.AUTH_ERROR);
        }

    }

    @ApiOperation("注册功能")
    @PostMapping("/register")
    public RequestEntity register(@RequestBody @ApiParam("注册会员信息") @NotNull MemberRequest memberRequest) {
        int count = loginService.register(memberRequest);
        if (count != 0) {
            return RequestEntity.success(RequestCode.SUCCESS);
        } else {
            throw new ControllerException(RequestCode.BUSINESS_UNKNOW_ERROR);
        }
    }
}
