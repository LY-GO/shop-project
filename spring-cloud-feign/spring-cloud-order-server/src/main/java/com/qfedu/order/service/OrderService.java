package com.qfedu.order.service;

import com.qfedu.order.domain.dto.OrderDto;
import com.qfedu.order.domain.dto.OrderRequestDto;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
public interface OrderService {
    /**
     * 生成订单
     *
     * @param orderDto
     * @return
     */
    OrderDto create(OrderRequestDto orderDto);
}
