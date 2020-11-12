package com.qfedu.order.service;

import com.qfedu.order.fallback.ProductFallBack;
import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.domain.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@FeignClient(value = "shop-product", path = "/product", fallback = ProductFallBack.class)
public interface ProductService {
    @GetMapping("/list")
    RequestEntity<Product> listOne(@RequestParam("productId") int productId);

    @PostMapping("/stock")
    RequestEntity<Integer> modifyStock(@RequestBody Product product);
}
