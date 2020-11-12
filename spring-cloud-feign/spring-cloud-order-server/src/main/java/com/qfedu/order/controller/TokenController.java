package com.qfedu.order.controller;

import com.qfedu.order.service.TokenService;
import com.zxl.request.exception.ControllerException;
import com.zxl.request.request.RequestCode;
import com.zxl.request.request.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    @Resource
    TokenService tokenService;

    @GetMapping("/get")
    public RequestEntity<String> getToken() {
        String token = tokenService.create();
        if (token != null) {
            return RequestEntity.success(RequestCode.SUCCESS, token);
        } else {
            throw new ControllerException(RequestCode.CONTROLLER_ERROR);
        }
    }
}
