package com.blog.core.system.auth.service.impl;

import com.blog.core.system.auth.dao.ManageAuthMapper;
import com.blog.core.system.auth.entity.AuthManageUser;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.auth.vo.ManageUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassNmae: AuthServiceImpl
 * @description: 用户登录获取用户信息
 * @Author: liulin
 * @Date: 2020/3/3 16:02
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ManageAuthMapper manageAuthMapper;

    @Transactional
    @Override
    public ManageUserInfoVO queryUserInfo() {
        //获取用户信息和拥有的角色信息
        SecurityUser securityUser = SecurityUtils.getUser();
        if (Objects.nonNull(securityUser)) {
            ManageUserInfoVO manageUserInfoVO = this.manageAuthMapper.selectUserInfoByUserId(securityUser.getUserId());
            manageUserInfoVO.setRoles((Set<String>) securityUser.getRoles());
            return manageUserInfoVO;
        }
        return new ManageUserInfoVO();
    }
}
