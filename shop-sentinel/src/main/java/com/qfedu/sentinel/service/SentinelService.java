package com.qfedu.sentinel.service;

import com.qfedu.sentinel.domain.AddressDto;
import com.qfedu.sentinel.fallback.AddressFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@FeignClient(value = "shop-address", path = "/address/list", fallback = AddressFallBackService.class)
public interface SentinelService {
    @GetMapping("/list")
    List<AddressDto> list(@RequestParam int uid, @RequestParam int page, @RequestParam int size);
}
