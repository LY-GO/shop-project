package com.qfedu.order.fallback;

import com.qfedu.order.domain.dto.DiscountDto;
import com.qfedu.order.domain.dto.RequestDiscountDto;
import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.service.DiscountService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Component
public class DiscountFallBack implements DiscountService {


    @Override
    public RequestEntity<List<DiscountDto>> list(int memberId, int page, int size) {
        return null;
    }

    @Override
    public RequestEntity<List<Integer>> find(RequestDiscountDto requestDiscountDto) {
        return null;
    }
}
