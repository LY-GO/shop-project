package com.qfedu.discount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.qfedu.discount.mapper")

public class DiscountApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscountApplication.class, args);
    }
}
