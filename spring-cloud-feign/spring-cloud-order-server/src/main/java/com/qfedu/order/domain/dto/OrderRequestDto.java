package com.qfedu.order.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/6
 */
@Data
public class OrderRequestDto {
    private Integer memberId;
    private String address;
    //private List<Integer> ids;
    private Integer id;
    private Integer expressType;
    private Integer count;
    private String phone;
    private List<Integer> disId;
}
