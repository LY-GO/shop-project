package com.qfedu.rest.handler;

import com.qfedu.rest.common.RequestEntity;
import com.qfedu.rest.exception.ControllerException;
import com.qfedu.rest.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public RequestEntity handlerException(Exception e) {
        log.error(e.getMessage());
        return RequestEntity.error();
    }


    @ExceptionHandler({ServiceException.class})
    public RequestEntity handlerServiceException(ServiceException se) {
        //控制台打印
        log.error(se.getMsg());
        //前端显示
        return RequestEntity.error();
    }

    @ExceptionHandler({ControllerException.class})
    public RequestEntity handlerControllerException(ControllerException ce) {
        //控制台打印
        log.error(ce.getMsg());
        //前端显示,这里要修改一下,要确定出是哪里哦抛出的异常
        return RequestEntity.error();
    }
}
