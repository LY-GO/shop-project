package com.qfedu.order.service;

import com.qfedu.order.fallback.DiscountFallBack;
import com.qfedu.order.domain.dto.DiscountDto;
import com.qfedu.order.domain.dto.RequestDiscountDto;
import com.qfedu.order.common.RequestEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@FeignClient(value = "shop-discount", path = "/discount", fallback = DiscountFallBack.class)
public interface DiscountService {
    @GetMapping("/list/{memberId}/{page}/{size}")
    RequestEntity<List<DiscountDto>> list(@PathVariable int memberId, @PathVariable int page, @PathVariable int size);

    @GetMapping("/find")
    RequestEntity<List<Integer>> find(@RequestBody RequestDiscountDto requestDiscountDto);
}
