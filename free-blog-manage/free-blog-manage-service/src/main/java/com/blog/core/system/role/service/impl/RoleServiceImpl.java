package com.blog.core.system.role.service.impl;

import com.blog.core.system.role.dao.RoleMapper;
import com.blog.core.system.role.dto.RoleAddDTO;
import com.blog.core.system.role.dto.RoleEditDTO;
import com.blog.core.system.role.service.RoleService;
import com.blog.core.system.role.vo.RoleDetailsVO;
import com.blog.core.system.role.vo.RoleInfoVO;
import com.blog.core.system.role.vo.RoleListVO;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleListVO> queryRoleByPage() {
        return roleMapper.selectRoleByPage();
    }

    @Override
    public List<RoleListVO> queryRoleList() {
        return roleMapper.selectRoleList();
    }

    @Override
    public List<RoleDetailsVO> queryRoleDetails(Integer roleId) {
        return this.roleMapper.selectRoleDetails(roleId);
    }

    @Override
    public List<RoleListVO> queryUserRoleList(Integer userId) {
        return this.roleMapper.selectUserRoleByUserId(userId);
    }

    @Transactional
    @Override
    public void addRole(RoleAddDTO RoleAddDTO) {

    }

    @Transactional
    @Override
    public void editRole(RoleEditDTO RoleEditDTO) {

    }

    @Transactional
    @Override
    public void disableRole(Integer roleId) {

    }

    @Transactional
    @Override
    public void enableRole(Integer roleId) {

    }

    @Override
    public Collection<GrantedAuthority> queryRoleInfoByUserId(Integer userId) {
        List<RoleInfoVO> roleInfoVOList = this.roleMapper.selectRoleInfoByUserId(userId);
        Set<String> permissions = new HashSet<>();
        if(CollectionUtils.isNotEmpty(roleInfoVOList)) {
            permissions.addAll(roleInfoVOList.stream().map(RoleInfoVO::getPermission)
                    .collect(Collectors.toSet()));
            permissions.addAll(roleInfoVOList.stream().map(RoleInfoVO::getPermission)
                    .collect(Collectors.toSet()));
        }
        return permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
