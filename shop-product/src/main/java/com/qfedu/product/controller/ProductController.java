package com.qfedu.product.controller;

import com.qfedu.product.commons.RequestCode;
import com.qfedu.product.commons.RequestEntity;
import com.qfedu.product.domain.entity.Product;
import com.qfedu.product.exception.ControllerException;
import com.qfedu.product.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@RestController
@RequestMapping("/product")
@Api("商品中心")
public class ProductController {
    @Resource
    ProductServiceImpl productService;

    @GetMapping("/list")
    public RequestEntity<Product> listOne(@RequestParam("productId") int productId) {
        Product product = productService.select(productId);
        if (product != null) {
            return RequestEntity.success(RequestCode.SUCCESS, product);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }
    }

    @PostMapping("/stock")
    public RequestEntity<Integer> modifyStock(@RequestBody Product product) {
        int i = productService.updateStock(product);
        if (i != 0) {
            return RequestEntity.error(RequestCode.SUCCESS, i);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }
    }
}
