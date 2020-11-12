package com.qfedu.user.domain.vo;


import com.qfedu.user.domain.dto.AddressDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class UserVo implements Serializable {
    private int uid;
    private String username;
    private List<AddressDto> address;
}
