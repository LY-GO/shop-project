package com.qfedu.discount.service;

import com.qfedu.discount.FallBack.ProductFallBack;
import com.qfedu.discount.common.RequestEntity;
import com.qfedu.discount.domain.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/9
 */
@FeignClient(value = "shop-product", path = "/product", fallback = ProductFallBack.class)
public interface ProductService {
    @GetMapping("/list")
    RequestEntity<Product> listOne(@RequestParam("productId") int productId);
}
