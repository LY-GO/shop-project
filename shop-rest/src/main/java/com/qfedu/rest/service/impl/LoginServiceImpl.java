package com.qfedu.rest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.rest.common.RequestCode;
import com.qfedu.rest.domain.Member;
import com.qfedu.rest.domain.request.MemberRequest;
import com.qfedu.rest.domain.vo.MemberVo;
import com.qfedu.rest.exception.ServiceException;
import com.qfedu.rest.mapper.MemberMapper;
import com.qfedu.rest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j

public class LoginServiceImpl implements LoginService {
    @Resource
    MemberMapper memberMapper;

    /**
     * 登录功能
     *
     * @param keyWord  传入用户名,手机号,邮箱
     * @param password 密码
     * @return
     */
    @Override
    public MemberVo login(String keyWord, String password) {
        MemberVo memberVo = null;
        QueryWrapper<Member> qw = new QueryWrapper<>();
        qw.eq("username", keyWord)
                .or()
                .eq("member_phone", keyWord)
                .or()
                .eq("member_email", keyWord);
        Member member = memberMapper.selectOne(qw);
        if (member != null) {
            if (member.getStatus() != 1) {
                if (member.getPassword().equals(password)) {
                    memberVo = new MemberVo();
                    BeanUtils.copyProperties(member, memberVo);
                    log.info(memberVo.toString());
                    return memberVo;
                } else {
                    throw new ServiceException(RequestCode.ACCOUNT_LOGIN_ERROR);
                }
            } else {
                throw new ServiceException(RequestCode.USER_ACCOUNT_LOCKED);
            }
        } else {
            throw new ServiceException(RequestCode.ACCOUNT_NOT_EXIST);
        }

    }

    /**
     * 注册功能
     *
     * @param memberRequest
     * @return
     */
    @Override
    public int register(MemberRequest memberRequest) {
        Member member = new Member();
        BeanUtils.copyProperties(memberRequest, member);
        int count = memberMapper.insert(member);

        return count;
    }
}
