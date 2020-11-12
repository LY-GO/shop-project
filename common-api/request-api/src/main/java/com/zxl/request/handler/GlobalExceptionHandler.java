package com.zxl.request.handler;


import com.zxl.request.exception.ServiceException;
import com.zxl.request.request.RequestCode;
import com.zxl.request.request.RequestEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author FUTURE
 * 这里的异常是给页面发送的异常,只能捕获到控制层的异常和其他抛到控制层的异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RequestEntity handlerException() {

        return RequestEntity.error(RequestCode.ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public RequestEntity handlerServiceException() {


        return RequestEntity.error(RequestCode.SERVICE_ERROR);
    }


}
