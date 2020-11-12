package com.qfedu.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.address.domain.dto.AddressDto;
import com.qfedu.address.service.AddressService;
import com.qfedu.address.utils.ColaBeanUtils;
import com.qfedu.address.mapper.AddressMapper;
import com.qfedu.address.domain.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangwei
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper mapper;

    @Override
    public List<AddressDto> list(int uid, int page, int size) {
        List<AddressDto> dtoList = new ArrayList<>();
        QueryWrapper<Address> qw = new QueryWrapper<>();
        qw.eq(Address.COL_MID, uid);
        IPage<Address> userPage = new Page<>(page, size);
        IPage<Address> addressPage = mapper.selectPage(userPage, qw);
        if (addressPage != null && addressPage.getRecords().size() > 0) {
            dtoList = ColaBeanUtils.copyListProperties(addressPage.getRecords(), AddressDto::new);
        }
        return dtoList;
    }

    /**
     * 增加地址
     *
     * @param addressDto
     * @return
     */
    @Override
    public int add(AddressDto addressDto) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        int insert = mapper.insert(address);
        return insert;
    }


}
