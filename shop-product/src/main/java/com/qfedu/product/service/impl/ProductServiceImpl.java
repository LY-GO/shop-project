package com.qfedu.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.product.domain.entity.Product;
import com.qfedu.product.mapper.ProductMapper;
import com.qfedu.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @Override
    public Product select(int productId) {
        Product product = productMapper.selectById(productId);
        return product;
    }

    /**
     * 修改库存
     *
     * @param product
     * @return
     */
    @Override
    public int updateStock(Product product) {
        Product product1 = productMapper.selectById(product.getId());
        product1.setProductStock(product.getProductStock());
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.lambda().and(productLambdaQueryWrapper -> productLambdaQueryWrapper.eq(Product::getId, product.getId()).eq(Product::getVersion, product.getVersion()));
        int update = productMapper.update(product1, qw);
        return update;
    }
}
