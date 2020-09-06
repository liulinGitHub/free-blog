package com.blog.core.system.onlineuser.service;

import com.blog.core.system.auth.entity.SecurityUser;

/**
 * @description: 在线用户service
 * @author: 950103
 * @create_time: 2020-04-02 17:41
 * @version: 1.0
 */
public interface ManageOnlineUserService {

    void addOnlineUser(SecurityUser currentUser);
}
