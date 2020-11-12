package com.qfedu.user.service;

import com.qfedu.user.domain.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "shop-address", path = "/address")
public interface UserService {
    @GetMapping("/list")
    List<AddressDto> list(@RequestParam("uid") int uid, @RequestParam("page") int page, @RequestParam("size") int size);
}
