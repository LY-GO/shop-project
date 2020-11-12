package com.qfedu.address.controller;


import com.qfedu.address.domain.dto.AddressDto;
import com.qfedu.address.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * VO  对应前端显示的数据
 * DTO  服务跟服务之间
 */
//分布式  rpc
// spring cloud    spring cloud  Netflix    spring cloud  alibaba
//REST  传递的json   http协议
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressService service;

    /**
     * 远程调用
     * 运维 测试 开发  并发压力
     * 服务的划分  根据业务进行划分   提供公共业务   ---  基础业务
     * 权限
     * 添加
     * 删除(假删除)
     * 更新地址信息
     * 查询单个地址信息
     * 根据用户名查询多个地址信息
     */
    @GetMapping("/list")
    public List<AddressDto> list(@RequestParam int uid, @RequestParam int page, @RequestParam int size) {
        return service.list(uid, page, size);
    }

    @PostMapping("/add")
    public String addAddress(@RequestBody @NotNull AddressDto addressDto) {
        int add = service.add(addressDto);
        if (add != 0) {
            return "增加地址成功";
        } else {
            return "增加地址失败";
        }
    }

}
