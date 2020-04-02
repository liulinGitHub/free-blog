package com.blog.core.system.auth.service;

import com.blog.core.system.auth.vo.ManageUserInfoVO;

/**
 * @ClassNmae: AuthService
 * @description:
 * @Author: liulin
 * @Date: 2020/3/3 16:00
 **/
public interface AuthService {

    /**
     * 查询用户信息
     *
     * @return
     */
    ManageUserInfoVO queryUserInfo();
}
