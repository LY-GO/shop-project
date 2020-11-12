package com.qfedu.discount.controller;

import com.qfedu.discount.common.RequestCode;
import com.qfedu.discount.common.RequestEntity;

import com.qfedu.discount.domain.dto.DiscountDto;
import com.qfedu.discount.domain.dto.RequestDiscountDto;

import com.qfedu.discount.exception.ControllerException;
import com.qfedu.discount.service.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@RestController
@RequestMapping("/discount")
@Api("优惠券中心")
public class DiscountController {
    @Resource
    DiscountService discountService;

    @GetMapping("/list/{memberId}/{page}/{size}")
    public RequestEntity<List<DiscountDto>> list(@PathVariable int memberId, @PathVariable int page, @PathVariable int size) {
        List<DiscountDto> select = discountService.select(memberId, page, size);
        if (select != null) {
            return RequestEntity.success(RequestCode.SUCCESS, select);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }
    }

    /**
     * 查找可以使用的优惠券
     *
     * @param requestDiscountDto
     * @return
     */
    @PostMapping("/find")
    public RequestEntity<List<Integer>> find(@RequestBody RequestDiscountDto requestDiscountDto) {
        List<Integer> list = discountService.selectLimit(requestDiscountDto);
        if (list != null) {
            return RequestEntity.success(RequestCode.SUCCESS, list);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }
    }
}
