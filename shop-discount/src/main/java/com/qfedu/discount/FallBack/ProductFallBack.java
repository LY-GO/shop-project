package com.qfedu.discount.FallBack;

import com.qfedu.discount.common.RequestEntity;
import com.qfedu.discount.domain.entity.Product;
import com.qfedu.discount.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/9
 */
@Component
public class ProductFallBack implements ProductService {
    @Override
    public RequestEntity<Product> listOne(@RequestParam("productId") int productId) {
        return null;
    }
}
