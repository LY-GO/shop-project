package com.qfedu.order.service.impl;

import com.qfedu.order.service.TokenService;
import com.zxl.redis.service.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    RedisService redisService;

    @Override
    public String create() {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisService.setEx(token, token, 2, TimeUnit.HOURS);
        return token;
    }
}
