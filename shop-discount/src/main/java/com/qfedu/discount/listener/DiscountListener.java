package com.qfedu.discount.listener;

import com.qfedu.discount.service.DiscountService;
import com.zxl.request.exception.RocketMQException;
import com.zxl.request.request.RequestCode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
@Component
@RocketMQMessageListener(consumerGroup = "discount-consumer", topic = "order-producer")
public class DiscountListener implements RocketMQListener<Integer> {
    @Resource
    DiscountService discountService;

    @Override
    public void onMessage(Integer message) {
        int i = discountService.updateStatus(message);
        if (i == 0) {
            throw new RocketMQException(RequestCode.MQ_ERROR);
        }
    }
}
