package com.qfedu.discount.domain.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Data
public class DiscountDto {

    private Integer id;

    /**
     * 会员id
     */

    private Integer memberId;

    /**
     * 获得数量
     */

    private Integer count;

    /**
     * 获得时间
     */

    private Date getTime;

    /**
     * 过期时间
     */

    private Date pastTime;

    /**
     * 1未过期0过期
     */

    private Integer status;


    private String discountKind;


    private BigDecimal discountMoney;

    private Integer discountDes;

    private Integer discountLimit;


    private Integer discountTotal;
}
