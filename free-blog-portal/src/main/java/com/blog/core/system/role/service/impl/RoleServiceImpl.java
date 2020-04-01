package com.blog.core.system.role.service.impl;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.menu.service.PortalMenuService;
import com.blog.core.system.menu.service.PortalRoleMenuService;
import com.blog.core.system.role.dao.PortalRoleMapper;
import com.blog.core.system.role.entity.domain.PortalUserRole;
import com.blog.core.system.role.entity.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.entity.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.role.entity.vo.PortalRoleVO;
import com.blog.core.system.role.service.PortalRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private PortalRoleMenuService portalRoleMenuService;

    /**
     * 查询所有角色信息
     * @return
     */
    @Override
    public List<PortalRoleVO> queryPortalRole() {
        List<PortalRoleVO> portalRoleVOList = this.portalRoleMapper.selectPortalRole();
        return portalRoleVOList;
    }

    /**
     * 添加角色信息
     * @param portalUserRoleAddQO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUserRole(PortalUserRoleAddQO portalUserRoleAddQO) {
        PortalUserRole userRole = MapperUtils.mapperBean(portalUserRoleAddQO, PortalUserRole.class);
        userRole.setUserRoleId(UUIDUtil.randomUUID32());
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

    /**
     * 根据用户id查询角色菜单
     * @param userId
     * @return
     */
    @Override
    public List<PortalRoleMenuInfoVO> queryRoleMenuInfoByUserId(String userId) {
        List<PortalRoleVO> portalRoleVOList = this.portalRoleMapper.selectRoleByUserId(userId);
        if(CollectionUtils.isNotEmpty(portalRoleVOList)){
            List<PortalRoleMenuInfoVO> portalRoleMenuInfoVOList = MapperUtils.mapperList(portalRoleVOList, PortalRoleMenuInfoVO.class);
            portalRoleMenuInfoVOList.parallelStream().forEach(portalRoleMenuInfoVO -> {
                List<String> menuIdList = this.portalRoleMenuService.queryMenuIdByRoleId(portalRoleMenuInfoVO.getRoleId());
                portalRoleMenuInfoVO.setMenuIdList(menuIdList);
            });
            return portalRoleMenuInfoVOList;
        }
        return null;
    }

    /**
     * 根据请求的URL查询所属的角色信息
     * @param url
     */
    @Override
    public List<PortalRoleVO> queryRoleByUrl(String url) {
        List<PortalRoleVO> portalRoleVOList = this.portalRoleMapper.selectRoleByUrl(url);
        return portalRoleVOList;
    }

}
