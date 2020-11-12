package com.qfedu.order.sendcallback;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
@Slf4j
public class DefaultSendCallBack implements SendCallback {
    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("success");
    }

    @Override
    public void onException(Throwable throwable) {
        log.error(throwable.getMessage());
    }
}
