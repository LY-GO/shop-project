package com.qfedu.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qfedu.points.mapper")
public class ShopRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopRestApplication.class, args);
    }
}
