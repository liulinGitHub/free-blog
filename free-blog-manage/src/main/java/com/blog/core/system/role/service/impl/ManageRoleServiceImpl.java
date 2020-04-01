package com.blog.core.system.role.service.impl;

import com.blog.core.system.role.dao.ManageRoleMapper;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: ManageRoleServiceImpl
 * @description: 角色service实现类
 * @author: liulin
 * @create: 2019-12-28 14:09
 * @Version: 1.0
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
    public List<ManageRoleInfoVO> queryRoleMenuInfoByUserId(String userId) {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> queryRoleInfoByUserId(String userId) {
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
