package com.qfedu.consumer.controller;


import com.qfedu.consumer.service.impl.ConsumerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/10
 */
@RestController
public class HelloController {
    @Resource
    ConsumerImpl consumer;

    @GetMapping("/test")
    public String testHello() {
        return consumer.testService();
    }
}
