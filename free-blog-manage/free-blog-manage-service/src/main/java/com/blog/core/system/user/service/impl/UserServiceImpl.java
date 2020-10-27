package com.blog.core.system.user.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.role.service.RoleService;
import com.blog.core.system.role.service.UserRoleService;
import com.blog.core.system.role.vo.RoleListVO;
import com.blog.core.system.user.dao.UserMapper;
import com.blog.core.system.user.dto.UserAddDTO;
import com.blog.core.system.user.dto.UserEditDTO;
import com.blog.core.system.user.dto.UserLoginInfoEditDTO;
import com.blog.core.system.user.entity.User;
import com.blog.core.system.user.service.UserService;
import com.blog.core.system.user.vo.UserDetailVO;
import com.blog.core.system.user.vo.UserListVO;
import com.blog.core.system.user.vo.UserLoginVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @description: 用户信息service
 * @author: 950103
 * @create_time: 2019/11/24 1:10
 * @version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Override
    public List<UserListVO> queryUserByPage() {
        return this.userMapper.queryUserByPage();
    }

    @Override
    public UserDetailVO queryUserDetails(Integer userId) {
        UserDetailVO userDetailVO = this.userMapper.selectUserByUserId(userId);
        if (Objects.nonNull(userDetailVO)) {
            List<RoleListVO> roleListVOList = roleService.queryUserRoleList(userId);
            if (CollectionUtils.isNotEmpty(roleListVOList)) {
                userDetailVO.setRoleList(roleListVOList);
            }
        }
        return userDetailVO;
    }

    @Override
    public UserLoginVO queryUserByUserName(String userName){
        return this.userMapper.selectUserByUserName(userName);
    }

    @Transactional
    @Override
    public void addUser(UserAddDTO userAddDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        User user = MapperUtils.mapperBean(userAddDTO, User.class);
        BCryptPasswordEncoder delegatingPasswordEncoder = new BCryptPasswordEncoder();
        String encode = delegatingPasswordEncoder.encode(userAddDTO.getPassword());
        user.setPassword(encode);
        user.setCreateId(currentUser.getUserId());
        user.setCreateTime(new Date());
        user.setEnable(EnableEnum.Enable_YES);
        userMapper.insertUser(user);
        //添加用户角色关联信息
        userRoleService.addUserRoleRelevance(user.getUserId(), userAddDTO.getRoleIdList());
    }

    @Transactional
    @Override
    public void editUser(UserEditDTO userEditDTO) {
        //修改用户信息
        SecurityUser currentUser = SecurityUtils.getUser();
        User user = MapperUtils.mapperBean(userEditDTO, User.class);
        user.setUpdateId(currentUser.getUserId());
        user.setUpdateTime(new Date());
        userMapper.updateUser(user);
        //添加用户角色关联信息
        userRoleService.addUserRoleRelevance(user.getUserId(), userEditDTO.getRoleIds());
    }

    @Transactional(rollbackFor = BlogRuntimeException.class)
    @Override
    public void editUserLoginInfo(UserLoginInfoEditDTO userLoginInfoEditDTO) {
        User user = MapperUtils.mapperBean(userLoginInfoEditDTO, User.class);
        userMapper.updateUserLoginInfo(user);
    }

    @Override
    public void disableUserByUserId(Integer userId) {

    }

    @Override
    public void enableUserByUserId(Integer userId) {

    }
}
