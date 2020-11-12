package com.qfedu.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qfedu.user.domain.dto.AddressDto;
import com.qfedu.user.service.UserService;
import com.qfedu.user.domain.vo.UserVo;
import okhttp3.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

/**
 * 规范
 * 维护
 */
// Url + 参数
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    OkHttpClient client;
    @Resource
    UserService userService;

    /**
     * 四大问题
     * feign
     * 查询用户的所有地址信息
     */
    @GetMapping("/addresses")
    public UserVo getAddressList(int uid, int page, int size) {
        String urlAddress = "http://127.0.0.1:8091/api/address/list";
        UserVo vo = new UserVo();
        vo.setUid(uid);
        vo.setUsername("admin");
        RequestBody requestBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("username", "admin");
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(urlAddress + "?" + "uid=" + uid + "&page=" + page + "&size=" + size)
                .build();
        // 1 微服务 服务跟服务之间的调用 一般都是同步
        // 2 移动端   前端  都是异步
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            List<AddressDto> list = JSONObject.parseArray(response.body().string(), AddressDto.class);
            vo.setAddress(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vo;
    }

    @PostMapping("/")
    public String putAddress(@RequestBody @NotNull AddressDto addressDto) {
        String urlAddress = "http://127.0.0.1:8091/api/address/add";

        String json = JSON.toJSONString(addressDto);
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(urlAddress)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        Response response = null;
        String s = null;
        try {
            response = call.execute();
            s = JSON.toJSONString(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * feign测试
     *
     * @param uid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    List<AddressDto> list(@RequestParam int uid, @RequestParam int page, @RequestParam int size) {
        List<AddressDto> list = userService.list(uid, page, size);
        return list;
    }
}
