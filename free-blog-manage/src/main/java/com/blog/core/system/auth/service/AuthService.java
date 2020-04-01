package com.blog.core.system.auth.service;

import com.blog.core.system.auth.entity.AuthManageUser;
import com.blog.core.system.auth.vo.ManageUserInfoVO;

import java.util.Map;

/**
 * @ClassNmae: AuthService
 * @description:
 * @Author: liulin
 * @Date: 2020/3/3 16:00
 **/
public interface AuthService {

    Map<String, Object> login(AuthManageUser authManageUser);

    /**
     * 查询用户信息
     *
     * @return
     */
    ManageUserInfoVO queryUserInfo();
}
