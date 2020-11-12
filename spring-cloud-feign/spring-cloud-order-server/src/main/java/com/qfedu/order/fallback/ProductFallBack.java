package com.qfedu.order.fallback;

import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.service.ProductService;
import com.qfedu.order.domain.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Component
public class ProductFallBack implements ProductService {
    @Override
    public RequestEntity<Product> listOne(int productId) {
        return null;
    }

    @Override
    public RequestEntity<Integer> modifyStock(Product product) {
        return null;
    }


}
