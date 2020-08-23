package com.blog.core.system.user.service;


import com.blog.core.system.user.vo.PortalUserInfoVO;

/**
 * @ClassName: PortalUserService
 * @Description: 公共service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
public interface PortalUserService {

    /**
     * 根据用户id查询用户信息
     * @return
     */
    PortalUserInfoVO queryUserInfo();

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     */
    PortalUserInfoVO queryUserByUserName(String username);


}
