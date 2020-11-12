package com.qfedu.discount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.discount.common.RequestEntity;

import com.qfedu.discount.domain.dto.DiscountDto;
import com.qfedu.discount.domain.dto.RequestDiscountDto;

import com.qfedu.discount.domain.entity.DiscountUser;
import com.qfedu.discount.domain.entity.Product;
import com.zxl.request.exception.ServiceException;
import com.qfedu.discount.mapper.DiscountUserMapper;
import com.qfedu.discount.service.DiscountService;
import com.qfedu.discount.service.ProductService;
import com.qfedu.discount.utils.ColaBeanUtils;

import com.zxl.request.request.RequestCode;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Service
public class DiscountServiceImpl implements DiscountService {
    @Resource
    DiscountUserMapper discountUserMapper;
    @Resource
    ProductService productService;

    @Override
    public List<DiscountDto> select(int memberId, int page, int size) {
        QueryWrapper<DiscountUser> qw = new QueryWrapper<>();
        qw.eq("member_id", memberId);
        IPage<DiscountUser> page1 = new Page<>(page, size);
        IPage<DiscountUser> discountUserIPage = discountUserMapper.selectPage(page1, qw);
        List<DiscountDto> list = ColaBeanUtils.copyListProperties(discountUserIPage.getRecords(), DiscountDto::new);
        return list;
    }

    /**
     * 查找是否有可用的优惠券
     *
     * @param
     * @return
     */
    @Override
    public List<Integer> selectLimit(RequestDiscountDto discountDto) {
        //计算商品初始价格
        List<Integer> ids = discountDto.getIds();
        BigDecimal total = new BigDecimal(0);
        List<Integer> disId = new ArrayList<>();
        ids.forEach(integer -> {
            RequestEntity<Product> productRequestEntity = productService.listOne(integer);
            Product product = productRequestEntity.getData();
            BigDecimal price = product.getNewPrice();
            BigDecimal count = new BigDecimal(discountDto.getCount());
            BigDecimal multiply = price.multiply(count);
            total.add(multiply);

        });
        //查询有哪些可以用的优惠券---自动化匹配,也可以自己选择用哪一张
        //可以用的优惠券有很多,我选择那一张呢?
        //我这里只筛选出可以用的优惠券,具体选择哪一张,由用户决定
        QueryWrapper<DiscountUser> qw = new QueryWrapper<>();
        qw.eq("member_id", discountDto.getMemberId());
        List<DiscountUser> discountUsers = discountUserMapper.selectList(qw);
        discountUsers.forEach(discountUser -> {
            Integer discountLimit = discountUser.getDiscountLimit();
            BigDecimal discountTotal = new BigDecimal(discountUser.getDiscountTotal());
            //先查看是否是全场通用
            if (discountLimit == 0) {
                if (total.compareTo(discountTotal) == 1) {
                    if (discountUser.getDiscountDes() == 1) {
                        disId.add(discountUser.getId());
                    } else if (discountUser.getDiscountDes() == 2) {
                        disId.add(discountUser.getId());
                    }
                }

                //红包不可以这样使用,回来修改
                disId.add(discountUser.getId());


            } else {
                ids.forEach(integer -> {
                    if (integer == discountLimit) {
                        if (total.compareTo(discountTotal) == 1) {
                            if (discountUser.getDiscountDes() == 1) {
                                disId.add(discountUser.getId());
                            } else if (discountUser.getDiscountDes() == 2) {
                                disId.add(discountUser.getId());
                            }


                        }
                        disId.add(discountUser.getId());
                    }
                });
            }


        });
        return disId;
    }

    /**
     * 修改优惠券状态
     *
     * @param disId
     * @return
     */
    @Override
    public int updateStatus(int disId) {
        DiscountUser discountUser = discountUserMapper.selectById(disId);
        discountUser.setStatus(1);
        int i = discountUserMapper.updateById(discountUser);
        if (i == 0) {
            throw new ServiceException(RequestCode.SERVICE_ERROR);
        }
        return i;
    }
}
