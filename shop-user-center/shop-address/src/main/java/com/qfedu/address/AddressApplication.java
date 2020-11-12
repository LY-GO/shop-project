package com.qfedu.address;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * swagger  前端 和移动端  小程序
 */
@SpringBootApplication
@MapperScan("com.qfedu.address.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class AddressApplication {
    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }
}
