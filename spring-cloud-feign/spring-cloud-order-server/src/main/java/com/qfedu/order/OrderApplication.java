package com.qfedu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/10
 */
@SpringBootApplication(scanBasePackages = {"com.zxl.redis", "com.qfedu.order"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.qfedu.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
