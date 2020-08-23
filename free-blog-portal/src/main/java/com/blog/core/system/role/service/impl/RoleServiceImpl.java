package com.blog.core.system.role.service.impl;

import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.menu.service.PortalRoleMenuService;
import com.blog.core.system.role.dao.PortalRoleMapper;
import com.blog.core.system.role.service.PortalRoleService;
import com.blog.core.system.role.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.role.vo.PortalRoleVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @description: 角色信息service
 * @Author: 950103
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

    @Override
    public List<PortalRoleVO> queryRoleByUserId(String userId){
        List<PortalRoleVO> portalRoleVOList = this.portalRoleMapper.selectRoleByUserId(userId);
        return portalRoleVOList;
    }

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
