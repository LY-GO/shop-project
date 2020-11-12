package com.qfedu.points.listener;


import com.qfedu.points.service.PointsService;
import com.zxl.request.exception.RocketMQException;
import com.zxl.request.request.RequestCode;
import org.apache.rocketmq.client.exception.MQBrokerException;
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
@RocketMQMessageListener(consumerGroup = "points-consumer-group", topic = "order-producer")
public class PointsListener implements RocketMQListener<Integer> {
    @Resource
    PointsService pointsService;

    @Override
    public void onMessage(Integer message) {
        int insert = pointsService.insert(message);
        if (insert == 0) {
            throw new RocketMQException(RequestCode.MQ_ERROR);
        }
    }
}
