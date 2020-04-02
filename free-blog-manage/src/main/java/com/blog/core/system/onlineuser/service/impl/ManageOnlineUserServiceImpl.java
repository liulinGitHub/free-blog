package com.blog.core.system.onlineuser.service.impl;

import com.blog.core.common.consts.RedisKeyConst;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.system.onlineuser.service.ManageOnlineUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param userId
     * @return void
     **/
    @Override
    public void addOnlineUser(String userId) {
        String onlineUserKey = RedisKeyConst.ONLINE_USER_ID_KEY;
        Set<String> userIdSet = (Set<String>)redisUtil.get(onlineUserKey);
        boolean isExistence = userIdSet.stream().anyMatch(b -> b.contains(userId));
        if (isExistence) {
            log.info("用户已经登录");
        } else {
            redisUtil.sAdd(onlineUserKey, userId);
        }
    }
}
