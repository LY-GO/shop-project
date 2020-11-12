package com.zxl.request.exception;

import com.zxl.request.request.RequestCode;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/22
 */
public class RocketMQException extends RuntimeException {
    private String msg;
    private int status;

    public RocketMQException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public RocketMQException(RequestCode requestCode) {
        //在全局异常哪里就不用强转了
        super(requestCode.getMsg());
        this.status = requestCode.getStatus();
    }
}
