package com.blog.core.system.onlineuser.service.impl;

import com.blog.core.common.consts.RedisKeyConst;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.HttpContextUtils;
import com.blog.core.common.utils.IPUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.onlineuser.entity.ManageOnlineUser;
import com.blog.core.system.onlineuser.service.ManageOnlineUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 在线用户信息service实现类
 * @author: 950103
 * @create_time: 2020-04-02 17:42
 * @version: 1.0
 */
@Slf4j
@Service
public class ManageOnlineUserServiceImpl implements ManageOnlineUserService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void addOnlineUser(SecurityUser currentUser) {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String onlineUserKey = RedisKeyConst.ONLINE_USER_ID_KEY + currentUser.getUserId();
        ManageOnlineUser manageOnlineUser = ManageOnlineUser.builder()
                .userName(currentUser.getUsername())
                .nickName(currentUser.getNickName())
                .sex(currentUser.getGender())
                .ipAddress(IPUtils.getIpAddr(request))
                .address(IPUtils.getIpSource(IPUtils.getIpAddr(request)))
                .browser(IPUtils.getBrowser(request))
                .build();
        redisUtil.sAdd(onlineUserKey, manageOnlineUser);
    }
}
