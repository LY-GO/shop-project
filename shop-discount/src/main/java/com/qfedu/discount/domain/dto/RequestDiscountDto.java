package com.qfedu.discount.domain.dto;


import lombok.Data;


import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/8
 */
@Data
public class RequestDiscountDto {

    private Integer memberId;
    private List<Integer> ids;
    private Integer count;

}
