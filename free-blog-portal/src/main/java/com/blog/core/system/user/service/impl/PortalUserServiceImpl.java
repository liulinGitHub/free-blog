package com.blog.core.system.user.service.impl;

import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.user.dao.PortalUserMapper;
import com.blog.core.system.user.vo.PortalUserInfoVO;
import com.blog.core.system.user.service.PortalUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @ClassName: PortalUserServiceImpl
 * @Description: 用户service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
@Service
public class PortalUserServiceImpl implements PortalUserService {

    @Resource
    private PortalUserMapper portalUserMapper;

    @Override
    public PortalUserInfoVO queryUserByUserName(String username) {
        PortalUserInfoVO portalUserInfoVO = this.portalUserMapper.selectUserByUserName(username);
        return portalUserInfoVO;
    }

    @Override
    public PortalUserInfoVO queryUserInfo() {
        String userId = SecurityUtils.getUserId();
        PortalUserInfoVO portalUserInfoVO = this.portalUserMapper.selectUserInfoByUserId(userId);
        return portalUserInfoVO;
    }

}
