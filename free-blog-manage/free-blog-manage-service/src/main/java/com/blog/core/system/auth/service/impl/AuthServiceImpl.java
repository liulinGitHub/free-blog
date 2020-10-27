package com.blog.core.system.auth.service.impl;

import com.blog.core.system.auth.dao.AuthMapper;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.auth.vo.UserInfoVO;
import com.blog.core.system.role.service.RoleService;
import com.blog.core.system.role.vo.RoleListVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    private AuthMapper authMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public UserInfoVO queryUserInfo() {
        //获取用户信息和拥有的角色信息
        SecurityUser currentUser = SecurityUtils.getUser();
        if (Objects.nonNull(currentUser)) {
            UserInfoVO userInfoVO = this.authMapper.selectUserInfoByUserId(currentUser.getUserId());
            if (Objects.isNull(userInfoVO)) {
                return new UserInfoVO();
            }
            List<RoleListVO> roleListVOList = roleService.queryUserRoleList(currentUser.getUserId());
            if (CollectionUtils.isNotEmpty(roleListVOList)) {
                List<Integer> roleIdList = roleListVOList.stream()
                        .filter(roleListVO -> Objects.nonNull(roleListVO.getRoleId()))
                        .map(RoleListVO::getRoleId).collect(Collectors.toList());
                userInfoVO.setRoles(roleIdList);
            }
            return userInfoVO;
        }
        return new UserInfoVO();
    }
}
