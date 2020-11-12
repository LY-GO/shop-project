package com.qfedu.points;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(value = "com.qfedu.points.mapper")
@EnableDiscoveryClient
public class ShopPointsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopPointsApplication.class, args);
    }
}
