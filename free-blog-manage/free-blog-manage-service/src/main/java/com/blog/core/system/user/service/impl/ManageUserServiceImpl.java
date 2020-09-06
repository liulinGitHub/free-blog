package com.blog.core.system.user.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.role.dto.ManageRoleIdDTO;
import com.blog.core.system.role.service.ManageUserRoleService;
import com.blog.core.system.user.dao.ManageUserMapper;
import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import com.blog.core.system.user.dto.ManageUserLoginInfoEditDTO;
import com.blog.core.system.user.entity.ManageUser;
import com.blog.core.system.user.service.ManageUserService;
import com.blog.core.system.user.vo.ManageUserDetailVO;
import com.blog.core.system.user.vo.ManageUserListVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description: 用户信息service
 * @author: 950103
 * @create_time: 2019/11/24 1:10
 * @version: 1.0
 **/
@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private ManageUserRoleService manageUserRoleService;

    @Override
    public List<ManageUserListVO> queryManageUserByPage() {
        List<ManageUserListVO> manageUserListVOList = this.manageUserMapper.queryManageUserByPage();
        return manageUserListVOList;
    }

    @Override
    public ManageUserDetailVO queryManageUserDetails(Integer userId) {
        return this.manageUserMapper.selectUserByUserId(userId);
    }

    @Override
    public ManageUserLoginVO queryUserByUserName(String userName){
        return this.manageUserMapper.selectUserByUserName(userName);
    }

    @Override
    public void addManageUser(ManageUserAddDTO manageUserAddDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        ManageUser manageUser = MapperUtils.mapperBean(manageUserAddDTO, ManageUser.class);
        manageUser.setPassword("$2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq");
        manageUser.setCreateId(currentUser.getUserId());
        manageUser.setCreateTime(new Date());
        manageUser.setEnable(EnableEnum.Enable_YES);
        this.manageUserMapper.insertManageUser(manageUser);
        //添加用户角色关联信息
        this.manageUserRoleService.addUserRoleRelevance(manageUser.getUserId(), manageUserAddDTO.getRoleIds());
    }

    @Transactional(rollbackFor = BlogRuntimeException.class)
    @Override
    public void editManageUser(ManageUserEditDTO manageUserEditDTO) {
        //修改用户信息
        SecurityUser currentUser = SecurityUtils.getUser();
        ManageUser manageUser = MapperUtils.mapperBean(manageUserEditDTO, ManageUser.class);
        manageUser.setUpdateId(currentUser.getUserId());
        manageUser.setUpdateTime(new Date());
        this.manageUserMapper.updateManageUser(manageUser);
        //添加用户角色关联信息
        this.manageUserRoleService.addUserRoleRelevance(manageUser.getUserId(), manageUserEditDTO.getRoleIds());
    }

    @Transactional(rollbackFor = BlogRuntimeException.class)
    @Override
    public void editManageUserLoginInfo(ManageUserLoginInfoEditDTO manageUserLoginInfoEditDTO) {
        ManageUser manageUser = MapperUtils.mapperBean(manageUserLoginInfoEditDTO, ManageUser.class);
        this.manageUserMapper.updateManageUserLoginInfo(manageUser);
    }

    @Override
    public void disableUserByUserId(Integer userId) {

    }

    @Override
    public void enableUserByUserId(Integer userId) {

    }
}
