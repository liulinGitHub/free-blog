package com.blog.core.system.role.service.impl;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.role.dao.PortalRoleMapper;
import com.blog.core.system.role.entity.domain.PortalUserRole;
import com.blog.core.system.role.entity.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.entity.vo.PortalRoleVO;
import com.blog.core.system.role.service.PortalRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNmae: RoleServiceImpl
 * @description: 角色信息service
 * @Author: liulin
 * @Date: 2019/4/14 23:20
 **/
@Slf4j
@Service("portalRoleService")
public class RoleServiceImpl implements PortalRoleService {

    @Resource
    private PortalRoleMapper portalRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUserRole(PortalUserRoleAddQO portalUserRoleAddQO) {
        PortalUserRole userRole = MapperUtils.mapperBean(portalUserRoleAddQO, PortalUserRole.class);
        userRole.setId(UUIDUtil.randomUUID32());
        userRole.setCreateId(RequestHolder.get()+"");
        userRole.setCreateTime(new Date());
        int result = this.portalRoleMapper.addUserRole(userRole);
        if(result < 1){
            log.error("保存失败！");
            throw new BlogRuntimeException("保存失败！");
        }
    }

    @Override
    public List<PortalRoleVO> queryRoleByUserId(String userId){
        List<PortalRoleVO> portalRoleVOList = this.portalRoleMapper.selectRoleByUserId(userId);
        return portalRoleVOList;
    }
}
