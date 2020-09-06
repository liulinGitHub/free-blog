package com.blog.core.system.auth.service.impl;

import com.blog.core.system.auth.dao.ManageAuthMapper;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.auth.vo.ManageUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassNmae: AuthServiceImpl
 * @description: 用户登录获取用户信息
 * @Author: 950103
 * @create_time: 2020/3/3 16:02
 * @version: 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ManageAuthMapper manageAuthMapper;

    @Override
    public ManageUserInfoVO queryUserInfo() {
        //获取用户信息和拥有的角色信息
        SecurityUser currentUser = SecurityUtils.getUser();
        if (Objects.nonNull(currentUser)) {
            ManageUserInfoVO manageUserInfoVO = this.manageAuthMapper.selectUserInfoByUserId(currentUser.getUserId());
            manageUserInfoVO.setRoles((Set<String>) currentUser.getRoles());
            return manageUserInfoVO;
        }
        return new ManageUserInfoVO();
    }
}
