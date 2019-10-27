package com.blog.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae: UserDetailsService
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:31
 **/
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private PortalUserService portalUserService;
//
//    /**
//     * 获取用户信息
//     * 返回UserDetails对象
//     * @param username
//     * @return
//     * @throws UsernameNotFoundException
//     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //PortalUserLoginVO portalUserLoginVO = this.portalUserService.queryUserByUserName(username);
        //return new SecurityUserDetails(portalUserLoginVO);
        return null;
    }
}
