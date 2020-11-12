package com.qfedu.consumer.service.impl;

import com.qfedu.api.service.HelloWord;
import com.qfedu.consumer.service.ConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/10
 */
@Service
public class ConsumerImpl implements ConsumerService {
    @Reference
    HelloWord helloWord;

    @Override
    public String testService() {
        return helloWord.hello();
    }
}
