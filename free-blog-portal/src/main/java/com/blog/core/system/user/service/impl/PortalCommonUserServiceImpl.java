package com.blog.core.system.user.service.impl;

import com.blog.core.system.user.dao.PortalCommonUserMapper;
import com.blog.core.system.user.entity.PortalCommonUser;
import com.blog.core.system.user.service.PortalCommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PortalCommonUserServiceImpl
 * @Description: 用户公共调用service
 * @date: 2020/7/19 0:13
 * @author: 950103
 * @Version 1.0
 */
@Service
public class PortalCommonUserServiceImpl implements PortalCommonUserService {

    @Autowired
    private PortalCommonUserMapper portalCommonUserMapper;

    @Override
    public PortalCommonUser queryPortalCommonUserByUserId(String userId) {
        return this.portalCommonUserMapper.selectPortalCommonUserByUserId(userId);
    }
}
