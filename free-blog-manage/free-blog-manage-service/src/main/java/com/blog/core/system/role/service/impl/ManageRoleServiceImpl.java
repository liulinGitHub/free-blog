package com.blog.core.system.role.service.impl;

import com.blog.core.system.role.dao.ManageRoleMapper;
import com.blog.core.system.role.dto.ManageRoleAddDTO;
import com.blog.core.system.role.dto.ManageRoleEditDTO;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 角色service实现类
 * @author: 950103
 * @create_time: 2019-12-28 14:09
 * @version: 1.0
 */
@Service
public class ManageRoleServiceImpl implements ManageRoleService {

    @Autowired
    private ManageRoleMapper manageRoleMapper;

    @Override
    public List<ManageRoleListVO> queryManageRoleByPage() {
        return manageRoleMapper.selectManageRoleByPage();
    }

    @Override
    public List<ManageRoleInfoVO> queryManageRoleDetails(Integer userId) {
        return this.manageRoleMapper.selectUserRoleByUserId(userId);
    }

    @Transactional
    @Override
    public void addManageRole(ManageRoleAddDTO manageRoleAddDTO) {

    }

    @Transactional
    @Override
    public void editManageRole(ManageRoleEditDTO manageRoleEditDTO) {

    }

    @Transactional
    @Override
    public void disableManageRole(Integer roleId) {

    }

    @Transactional
    @Override
    public void enableManageRole(Integer roleId) {

    }

    @Override
    public Collection<GrantedAuthority> queryRoleInfoByUserId(Integer userId) {
        List<ManageRoleInfoVO> manageRoleInfoVOList = this.manageRoleMapper.selectRoleInfoByUserId(userId);
        Set<String> permissions = new HashSet<>();
        if(CollectionUtils.isNotEmpty(manageRoleInfoVOList)) {
            permissions.addAll(manageRoleInfoVOList.stream().map(ManageRoleInfoVO::getPermission)
                    .collect(Collectors.toSet()));
            permissions.addAll(manageRoleInfoVOList.stream().map(ManageRoleInfoVO::getRolePermission)
                    .collect(Collectors.toSet()));
        }
        return permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
