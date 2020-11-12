package com.qfedu.points.service;


import com.qfedu.points.domain.entity.PointsTotal;
import com.qfedu.points.domain.request.RequestPoints;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/3
 */
public interface PointsService {
    /**
     * 查询所有积分信息
     *
     * @return
     */
    RequestPoints selectAll(int id);

    /**
     * 积分兑换
     *
     * @return
     */
    int insert(int id);

    /**
     * 查询会员积分
     *
     * @param id
     * @return
     */
    PointsTotal select(int id);
}
