package com.qfedu.rest.exception;

import com.qfedu.rest.common.RequestCode;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private String msg;
    private int status;

    public ServiceException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public ServiceException(RequestCode requestCode) {
        //在全局异常哪里就不用强转了
        super(requestCode.getMsg());
        this.status = requestCode.getStatus();
    }
}
