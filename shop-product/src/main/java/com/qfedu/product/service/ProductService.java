package com.qfedu.product.service;

import com.qfedu.product.domain.entity.Product;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
public interface ProductService {
    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    Product select(int productId);

    /**
     * 修改库存
     *
     * @param product
     * @return
     */
    int updateStock(Product product);
}
