package com.blog.core.system.user.service;

import com.blog.core.system.user.entity.PortalCommonUser;

/**
 * @ClassName: PortalCommonUserService
 * @Description: 用户公共调用service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
public interface PortalCommonUserService {

    /**
     * 根据用户名查询用户信息
     * 该方法提供给包含用户信息的各个模块使用
     *
     * @param userId
     * @return
     */
    PortalCommonUser queryPortalCommonUserByUserId(String userId);
}
