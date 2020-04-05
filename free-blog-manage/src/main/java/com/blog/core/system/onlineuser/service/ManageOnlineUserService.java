package com.blog.core.system.onlineuser.service;

import com.blog.core.system.auth.entity.SecurityUser;

/**
 * @program: ManageOnlineUserService
 * @description: 在线用户service
 * @author: liulin
 * @create: 2020-04-02 17:41
 * @Version: 1.0
 */
public interface ManageOnlineUserService {

    void addOnlineUser(SecurityUser securityUser);
}
