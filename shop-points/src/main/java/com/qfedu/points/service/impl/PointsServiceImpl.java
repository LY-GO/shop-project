package com.qfedu.points.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.points.common.RequestCode;
import com.qfedu.points.domain.entity.Points;
import com.qfedu.points.domain.entity.PointsMember;
import com.qfedu.points.domain.entity.PointsTotal;
import com.qfedu.points.domain.request.RequestPoints;
import com.qfedu.points.exception.ServiceException;
import com.qfedu.points.mapper.PointsMemberMapper;
import com.qfedu.points.mapper.PointsTotalMapper;
import com.qfedu.points.service.PointsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/3
 */
@Service
public class PointsServiceImpl implements PointsService {
    @Resource
    PointsMemberMapper pointsMemberMapper;
    @Resource
    PointsTotalMapper pointsTotalMapper;

    /**
     * 查询会员积分
     *
     * @return
     */

    @Override
    public RequestPoints selectAll(int id) {
        RequestPoints requestPoints = new RequestPoints();
        PointsTotal pointsTotal = pointsTotalMapper.selectById(id);
        BeanUtils.copyProperties(pointsTotal, requestPoints);

        return requestPoints;
    }

    /**
     * 积分兑换
     * 10积分兑换0.1元
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int insert(int id) {

        PointsTotal pointsTotal = pointsTotalMapper.selectById(id);
        Integer total = pointsTotal.getTotal();
        if (total >= 10) {
            int count = total % 10;
            int count1 = total / 10;
            //暂时未用到这个功能

            PointsTotal pointsTotal1 = new PointsTotal();
            //更新总积分表
            pointsTotal1.setTotalCon(count1 * 10);
            pointsTotal1.setId(id);
            pointsTotal.setTotal(count);
            int insert = pointsTotalMapper.insert(pointsTotal1);
            //更新会员积分表
            PointsMember pointsMember = new PointsMember();
            pointsMember.setGetTime(new Date());
            pointsMember.setMemberId(id);
            pointsMember.setPointsKind("积分兑换");
            pointsMember.setPointsValue(-(count1 * 10));
            int insert1 = pointsMemberMapper.insert(pointsMember);
            if (insert != 1 && insert1 != 1) {
                throw new ServiceException(RequestCode.DATA_IS_WRONG);
            } else {
                return 1;
            }


        } else {
            throw new ServiceException(RequestCode.DATA_IS_WRONG);
        }

    }

    /**
     * 查询会员积分
     *
     * @param id
     * @return
     */
    @Override
    public PointsTotal select(int id) {
        PointsTotal pointsTotal = pointsTotalMapper.selectById(id);
        return pointsTotal;
    }


}

