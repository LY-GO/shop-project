package com.qfedu.order.config;


import com.qfedu.order.interceptor.ApilempotentInterceptorHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * token 登录 jwt
 * 注册拦截器
 */
@Component
public class CustomWebmvcAdapter implements WebMvcConfigurer {
    @Resource
    ApilempotentInterceptorHandler apilempotentInterceptorHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apilempotentInterceptorHandler);
    }
}
