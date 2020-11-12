package com.qfedu.sentinel.domain;

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
