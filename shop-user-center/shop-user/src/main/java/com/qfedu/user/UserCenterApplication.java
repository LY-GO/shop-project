package com.qfedu.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.qfedu.user.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class UserCenterApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
