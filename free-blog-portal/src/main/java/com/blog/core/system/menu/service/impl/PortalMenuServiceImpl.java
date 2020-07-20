package com.blog.core.system.menu.service.impl;

import com.blog.core.system.menu.dao.PortalMenuMapper;
import com.blog.core.system.menu.service.PortalMenuService;
import com.blog.core.system.menu.vo.PortalMenuTree;
import com.blog.core.system.menu.vo.PortalMenuVO;
import com.blog.core.system.user.service.PortalUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: PortalMenuServiceImpl
 * @description: 角色信息service
 * @Author: 950103
 * @Date: 2019/4/14 23:20
 **/
@Slf4j
@Service("portalMenuService")
public class PortalMenuServiceImpl implements PortalMenuService {

    @Resource
    private PortalMenuMapper portalMenuMapper;

    @Resource
    private PortalUserService portalUserService;

    /**
     * 查询全部菜单
     * @return
     */
    @Override
    public List<PortalMenuVO> queryMenuList(){
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectMenuList();
        return portalMenuVOList;
    }

    @Override
    public List<PortalMenuVO> queryMenuByUserId(String userId){
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectMenuByRoleId(userId);
        return portalMenuVOList;
    }

    @Override
    public List<PortalMenuTree> queryUserMenu(){

        return null;
    }
}
