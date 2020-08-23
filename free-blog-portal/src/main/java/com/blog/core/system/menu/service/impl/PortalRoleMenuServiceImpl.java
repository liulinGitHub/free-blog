package com.blog.core.system.menu.service.impl;

import com.blog.core.system.menu.dao.PortalRoleMenuMapper;
import com.blog.core.system.menu.service.PortalRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PortalRoleMenuServiceImpl
 * @description: 角色菜单实现类
 * @author: 950103
 * @create: 2019-10-30 16:10
 * @Version: 1.0
 */
@Service("portalRoleMenuService")
public class PortalRoleMenuServiceImpl implements PortalRoleMenuService {

    @Resource
    private PortalRoleMenuMapper portalRoleMenuMapper;

    /**
     * 根据角色id查询所属菜单id
     * @param roleId
     * @return
     */
    @Override
    public List<String> queryMenuIdByRoleId(String roleId){
        List<String> menuIdList = this.portalRoleMenuMapper.selectMenuIdByRoleId(roleId);
        return menuIdList;
    }
}
