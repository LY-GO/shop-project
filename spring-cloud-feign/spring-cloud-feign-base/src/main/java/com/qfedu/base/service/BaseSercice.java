package com.qfedu.base.service;

import com.qfedu.base.domain.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/6
 */
@FeignClient(value = "spring-cloud-order-server", path = "/order")
public interface BaseSercice {
    @PostMapping("/create")
    OrderDto createOrder();
}
