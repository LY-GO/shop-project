package com.qfedu.order.fallback;

import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.domain.entity.PointsTotal;
import com.qfedu.order.service.PointsService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Component
public class PointsFallBack implements PointsService {
    @Override
    public RequestEntity<PointsTotal> total(int id) {
        return null;
    }
}
