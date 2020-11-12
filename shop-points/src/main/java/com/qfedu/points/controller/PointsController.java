package com.qfedu.points.controller;

import com.qfedu.points.common.RequestCode;
import com.qfedu.points.common.RequestEntity;
import com.qfedu.points.domain.entity.PointsTotal;
import com.qfedu.points.domain.request.RequestPoints;
import com.qfedu.points.exception.ControllerException;
import com.qfedu.points.exception.ServiceException;
import com.qfedu.points.service.impl.PointsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/3
 */

@RestController
@RequestMapping("/points")
@Api("积分中心")
@Validated
public class PointsController {
    @Resource
    PointsServiceImpl pointsService;

    /**
     * 查询会员积分信息
     *
     * @param id
     * @return
     */
    @GetMapping("/list")
    public RequestEntity<RequestPoints> list(@ApiParam("会员id") int id) {
        RequestPoints requestPoints = pointsService.selectAll(id);
        if (requestPoints != null) {
            return RequestEntity.success(RequestCode.SUCCESS, requestPoints);
        } else {
            throw new ServiceException(RequestCode.ERROR);
        }
    }

    @GetMapping("/total")
    public RequestEntity<PointsTotal> total(@RequestParam("id") int id) {
        PointsTotal pointsTotal = pointsService.select(id);
        if (pointsTotal != null) {
            return RequestEntity.success(RequestCode.SUCCESS, pointsTotal);
        } else {
            throw new ControllerException(RequestCode.ERROR);
        }
    }

    /**
     * 积分兑换
     *
     * @param id
     * @return
     */
    @PutMapping("/covert")
    public RequestEntity convert(int id) {
        int insert = pointsService.insert(id);
        if (insert != 0) {
            return RequestEntity.success(RequestCode.SUCCESS);
        } else {
            throw new ControllerException(RequestCode.BUSINESS_UNKNOW_ERROR);
        }


    }

}
