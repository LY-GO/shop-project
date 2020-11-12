package com.qfedu.base.domain.dto;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/6
 */
@Data
public class OrderDto {
    private String orderNo;
    private BigDecimal total;
    private String subject;
}
