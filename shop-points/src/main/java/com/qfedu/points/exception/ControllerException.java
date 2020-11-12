package com.qfedu.points.exception;

import com.qfedu.points.common.RequestCode;
import lombok.Data;

@Data
public class ControllerException extends RuntimeException {
    private String msg;
    private int status;

    public ControllerException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public ControllerException(RequestCode requestCode) {
        //在全局异常哪里就不用强转了
        super(requestCode.getMsg());
        this.status = requestCode.getStatus();
    }
}
