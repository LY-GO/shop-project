package com.qfedu.discount.service;

import com.qfedu.discount.domain.dto.DiscountDto;
import com.qfedu.discount.domain.dto.RequestDiscountDto;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
public interface DiscountService {
    /**
     * 查询会员优惠券
     *
     * @param memberId
     * @return
     */
    List<DiscountDto> select(int memberId, int page, int size);

    /**
     * 查找是否可以使用优惠券
     *
     * @return
     */
    List<Integer> selectLimit(RequestDiscountDto requestDiscountDto);

    /**
     * 修改优惠券状态
     *
     * @param disId
     * @return
     */
    int updateStatus(int disId);
}
