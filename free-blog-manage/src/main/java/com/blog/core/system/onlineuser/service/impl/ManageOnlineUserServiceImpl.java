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
import java.util.Set;

/**
 * @program: ManageOnlineUserServiceImpl
 * @description: 在线用户信息service实现类
 * @author: liulin
 * @create: 2020-04-02 17:42
 * @Version: 1.0
 */
@Slf4j
@Service
public class ManageOnlineUserServiceImpl implements ManageOnlineUserService {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 添加在线用户
     *
     * @param securityUser
     * @return void
     **/
    @Override
    public void addOnlineUser(SecurityUser securityUser) {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String onlineUserKey = RedisKeyConst.ONLINE_USER_ID_KEY + securityUser.getUserId();
        ManageOnlineUser manageOnlineUser = ManageOnlineUser.builder()
                .userName(securityUser.getUsername())
                .nickName(securityUser.getNickName())
                .sex(securityUser.getSex())
                .ipAddress(IPUtils.getIpAddr(request))
                .address(IPUtils.getIpSource(IPUtils.getIpAddr(request)))
                .browser(IPUtils.getBrowser(request))
                .build();
        redisUtil.sAdd(onlineUserKey, manageOnlineUser);
    }
}
