package com.qfedu.address.service;


import com.qfedu.address.domain.dto.AddressDto;


import java.util.List;

public interface AddressService {
    List<AddressDto> list(int uid, int page, int size);

    int add(AddressDto addressDto);
}
