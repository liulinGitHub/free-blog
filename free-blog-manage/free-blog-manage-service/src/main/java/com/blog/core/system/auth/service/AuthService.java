package com.blog.core.system.auth.service;

import com.blog.core.system.auth.vo.ManageUserInfoVO;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/3/3 16:00
 * @version: 1.0
 **/
public interface AuthService {

    /**
     * 查询用户信息
     *
     * @return
     */
    ManageUserInfoVO queryUserInfo();
}
