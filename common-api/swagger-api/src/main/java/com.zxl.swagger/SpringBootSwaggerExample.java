package com.zxl.swagger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
//开启对swagger的支持
@EnableSwagger2
public class SpringBootSwaggerExample {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerExample.class, args);
    }
}
