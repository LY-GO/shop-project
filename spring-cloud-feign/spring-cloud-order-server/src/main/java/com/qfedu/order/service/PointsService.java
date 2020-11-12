package com.qfedu.order.service;

import com.qfedu.order.fallback.PointsFallBack;
import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.domain.entity.PointsTotal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@FeignClient(value = "shop-points", path = "/points", fallback = PointsFallBack.class)
public interface PointsService {
    @GetMapping("/total")
    RequestEntity<PointsTotal> total(@RequestParam("id") int id);
}
