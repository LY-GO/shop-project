package com.qfedu.provider.service.impl;


import com.qfedu.api.service.HelloWord;
import org.apache.dubbo.config.annotation.Service;


/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/10
 */
@Service
public class HelloWordService implements HelloWord {
    @Override
    public String hello() {
        return "hello 磊爷";
    }
}
