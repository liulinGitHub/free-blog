package com.blog.core.system.user.service.impl;

import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.role.dto.ManageRoleIdDTO;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.service.ManageUserRoleService;
import com.blog.core.system.user.dao.ManageUserMapper;
import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import com.blog.core.system.user.dto.ManageUserLoginInfoEditDTO;
import com.blog.core.system.user.entity.ManageUser;
import com.blog.core.system.user.vo.ManageUserDetailVO;
import com.blog.core.system.user.vo.ManageUserListVO;
import com.blog.core.system.user.service.ManageUserService;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNmae: ManageUserServiceImpl
 * @description: 用户信息service
 * @Author: liulin
 * @Date: 2019/11/24 1:10
 **/
@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private ManageUserRoleService manageUserRoleService;

    @Override
    public List<ManageUserListVO> queryUserByPage() {
        return this.manageUserMapper.queryUserByPage();
    }

    @Override
    public ManageUserDetailVO queryUserByUserId(String userId) {
        return this.manageUserMapper.selectUserByUserId(userId);
    }

    /**
     * @Author liulin
     * @Description 根据用户名查询登录用户信息
     * @Date 2019/12/28 14:04
     * @Param [userName]
     * @return com.blog.core.system.user.vo.ManageUserLoginVO
     **/
    @Override
    public ManageUserLoginVO queryUserByUserName(String userName){
        return this.manageUserMapper.selectUserByUserName(userName);
    }

    @Override
    public void addUser(ManageUserAddDTO manageUserAddDTO) {

    }

    @Transactional
    @Override
    public void editManageUser(ManageUserEditDTO manageUserEditDTO) {
        //修改用户信息
        SecurityUser user = SecurityUtils.getUser();
        ManageUser manageUser = MapperUtils.mapperBean(manageUserEditDTO, ManageUser.class);
        manageUser.setUpdateId(user.getUserId());
        manageUser.setUpdateTime(new Date());
        this.manageUserMapper.updateManageUser(manageUser);
        //添加用户角色关联信息
        List<String> roleIdList = manageUserEditDTO.getRoles().stream().map(ManageRoleIdDTO::getRoleId).collect(Collectors.toList());
        this.manageUserRoleService.addUserRoleRelevance(manageUser.getUserId(), roleIdList);
    }

    @Transactional
    @Override
    public void editManageUserLoginInfo(ManageUserLoginInfoEditDTO manageUserLoginInfoEditDTO) {
        ManageUser manageUser = MapperUtils.mapperBean(manageUserLoginInfoEditDTO, ManageUser.class);
        this.manageUserMapper.updateManageUserLoginInfo(manageUser);
    }

    @Override
    public void disableUserByUserId(String userId) {

    }

    @Override
    public void enableUserByUserId(String userId) {

    }
}
