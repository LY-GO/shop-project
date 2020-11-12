package com.qfedu.order.controller;

import com.qfedu.order.annotation.Apilempotent;
import com.qfedu.order.common.RequestCode;
import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.domain.dto.OrderDto;
import com.qfedu.order.domain.dto.OrderRequestDto;

import com.qfedu.order.exception.ControllerException;
import com.qfedu.order.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/6
 */
@RestController
@RequestMapping("/order")
@Validated
@Api("订单中心")
public class OrderController {
    @Resource
    OrderServiceImpl orderService;

    @PostMapping("/create")
    @Apilempotent
    public RequestEntity<OrderDto> createOrder(@RequestBody @NotNull @ApiParam("生成订单信息") OrderRequestDto orderRequestDto) {
        OrderDto orderDto = orderService.create(orderRequestDto);
        if (orderDto != null) {
            return RequestEntity.error(RequestCode.ERROR, orderDto);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }


    }
}
