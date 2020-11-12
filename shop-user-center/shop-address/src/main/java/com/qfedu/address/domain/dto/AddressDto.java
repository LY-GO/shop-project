package com.qfedu.address.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class AddressDto implements Serializable {
    private Integer id;
    private String name;
    private Integer mid;
}
