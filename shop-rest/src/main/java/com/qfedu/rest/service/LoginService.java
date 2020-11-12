package com.qfedu.rest.service;

import com.qfedu.rest.domain.Member;
import com.qfedu.rest.domain.request.MemberRequest;

public interface LoginService {
    /**
     * 登录功能
     *
     * @param keyWord  传入用户名,手机号,邮箱
     * @param password 密码
     * @return
     */
    Member login(String keyWord, String password);

    /**
     * 注册功能
     *
     * @param memberRequest
     * @return
     */
    int register(MemberRequest memberRequest);
}
