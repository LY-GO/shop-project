package com.qfedu.order.interceptor;

import com.qfedu.order.annotation.Apilempotent;
import com.zxl.redis.service.RedisService;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
@RestControllerAdvice
public class ApilempotentInterceptorHandler implements HandlerInterceptor {
    //定义接受token的成员变量
    public static final String HEADER_TOKEN_NAME = "token";
    @Resource
    RedisService redisService;

    /**
     * 判断幂等性
     * 拦截controller请求
     * true放行 false 拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isSuccess = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Apilempotent methodAnnotation = method.getMethodAnnotation(Apilempotent.class);
            if (methodAnnotation != null) {
                isSuccess = checkToken(request);
            }
        }
        return isSuccess;
    }

    /**
     * 客服端必须写token信息
     * head 传递数据  key: value  例如 token: 1234
     */
    private boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(HEADER_TOKEN_NAME);
        //客户端没有发送token过来则报错
        if (token == null) {
            throw new Exception("token 不存在");
        }
        if (redisService.hasKey(token)) {
            redisService.delete(token);
            return true;
        }
        //redis里面也没有就放行
        //这里逻辑有点不通,明天来解决
        return false;
    }
}
