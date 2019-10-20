package com.blog.core.system.menu.service.impl;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.SupperEnum;
import com.blog.core.common.exceptions.TokenException;
import com.blog.core.system.menu.dao.PortalMenuMapper;
import com.blog.core.system.menu.entity.vo.PortalMenuTree;
import com.blog.core.system.menu.service.PortalMenuService;
import com.blog.core.system.user.entity.vo.PortalUserVO;
import com.blog.core.system.user.service.PortalUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.blog.core.system.menu.entity.vo.PortalMenuVO;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassNmae: SysBaseMenuServiceImpl
 * @description: 角色信息service
 * @Author: liulin
 * @Date: 2019/4/14 23:20
 **/
@Slf4j
@Service("portalMenuService")
public class PortalMenuServiceImpl implements PortalMenuService {

    @Resource
    private PortalMenuMapper portalMenuMapper;

    @Resource
    private PortalUserService portalUserService;

    @Override
    public List<PortalMenuVO> queryMenuByUserId(String userId){
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectMenuByRoleId(userId);
        return portalMenuVOList;
    }

    @Override
    public List<PortalMenuTree> queryUserMenu(){
        List<PortalMenuVO> portalMenuVOList = new ArrayList<>();
        List<PortalMenuTree> portalMenuTreeList = new ArrayList<>();
        //获取当前登录用户ID
        String userId = String.valueOf(RequestHolder.get());
        if("null".equals(userId)){
            throw new TokenException();
        }
        //根据用户id查询用户信息
        PortalUserVO portalUserVO = this.portalUserService.queryUserById(userId);
        //如果是超级管理员就获得所有菜单
        if(SupperEnum.SUPPER.getValue().equals(portalUserVO.getIsSupper())){
            portalMenuVOList = this.portalMenuMapper.selectUserMenu();
        }else {
            portalMenuVOList = this.portalMenuMapper.selectUserMenuByUserId(portalUserVO.getId());
        }
        //按照父ID分组，找出所有子节点
        Map<String, List<PortalMenuVO>> groupMap = portalMenuVOList.stream().filter(b -> null != b.getParentId()).collect(Collectors.groupingBy(PortalMenuVO::getParentId));
        if(Objects.nonNull(groupMap) && groupMap.size() > 0){
            portalMenuTreeList = portalMenuVOList.stream().filter(menu -> null == menu.getParentId() && groupMap.containsKey(menu.getParentId()))
                    .map(menu -> this.getChildMenuTree(groupMap, menu))
                    .sorted(Comparator.comparingInt(PortalMenuTree::getMenuSort))
                    .collect(Collectors.toList());
            return portalMenuTreeList;
        }
        return null;
    }

    private PortalMenuTree getChildMenuTree(Map<String, List<PortalMenuVO>> groupMap, PortalMenuVO menuVO){
        PortalMenuTree portalMenuTree = new PortalMenuTree(menuVO);
        List<PortalMenuVO> childMenuList = groupMap.get(menuVO.getParentId());
        if(CollectionUtils.isNotEmpty(childMenuList)){
            childMenuList = childMenuList.stream().sorted(Comparator.comparingInt(PortalMenuVO::getMenuSort)).collect(Collectors.toList());
            if(null == portalMenuTree.getChilds()){
                portalMenuTree.setChilds(new ArrayList<>());
            }
        }
        //对当前的菜单的所有子菜单进行递归
        for (PortalMenuVO _menu : childMenuList) {
            portalMenuTree.getChilds().add(getChildMenuTree(groupMap, _menu));
        }
        return portalMenuTree;
    }
}
