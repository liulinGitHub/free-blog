package com.blog.core.system.menu.service.impl;

import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.menu.dao.PortalMenuMapper;
import com.blog.core.system.menu.service.PortalMenuService;
import com.blog.core.system.menu.vo.PortalMenuTree;
import com.blog.core.system.menu.vo.PortalMenuVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 查询全部菜单
     * @return
     */
    @Override
    public List<PortalMenuTree> queryMenuList() {
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectMenuList();
        return this.builderMenuTree(portalMenuVOList);
    }

    @Override
    public List<PortalMenuTree> queryUserPortalMenuList() {
        String userId = SecurityUtils.getUserId();
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectUserMenuByUserId(userId);
        return this.builderMenuTree(portalMenuVOList);
    }

    @Override
    public List<PortalMenuTree> queryRoleMenu(String roleId) {
        List<PortalMenuVO> portalMenuVOList = this.portalMenuMapper.selectMenuByRoleId(roleId);
        return this.builderMenuTree(portalMenuVOList);
    }

    /**
     * 构建菜单树
     *
     * @param portalMenuVOList
     * @return
     */
    private List<PortalMenuTree> builderMenuTree(List<PortalMenuVO> portalMenuVOList) {
        if (CollectionUtils.isEmpty(portalMenuVOList)) {
            return new ArrayList<>();
        }
        List<PortalMenuVO> prentMenuList = portalMenuVOList.parallelStream()
                .filter(portalMenuVO -> StringUtils.isBlank(portalMenuVO.getParentId()))
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(prentMenuList)
            && prentMenuList.size() > 0) {
            prentMenuList = prentMenuList.stream().sorted(Comparator.comparing(PortalMenuVO::getMenuSort)).collect(Collectors.toList());
            List<PortalMenuTree> portalMenuTreeList = new ArrayList<>(prentMenuList.size());
            for (PortalMenuVO prentMenu : prentMenuList) {
                PortalMenuTree portalMenuTree = MapperUtils.mapperBean(prentMenu, PortalMenuTree.class);
                for (PortalMenuVO portalMenuVO : portalMenuVOList) {
                    if (portalMenuVO.getParentId().equals(prentMenu.getMenuId())) {
                        List<PortalMenuTree> childrenList = this.builderChildrenMenu(prentMenu.getMenuId(), portalMenuVOList);
                        portalMenuTree.setChildrenList(childrenList);
                    }
                }
                portalMenuTreeList.add(portalMenuTree);
            }
            return portalMenuTreeList;
        }
        return new ArrayList<>();
    }

    /**
     * 构建子菜单
     *
     * @param menuId
     * @param portalMenuVOList
     * @return
     */
    private List<PortalMenuTree> builderChildrenMenu(String menuId, List<PortalMenuVO> portalMenuVOList) {
        List<PortalMenuTree> childrenList = new ArrayList();
        for (PortalMenuVO portalMenuVO : portalMenuVOList) {
            if (portalMenuVO.getParentId().equals(menuId)) {
                PortalMenuTree portalMenuTree = MapperUtils.mapperBean(portalMenuVO, PortalMenuTree.class);
                childrenList.add(portalMenuTree);
            }
        }
        for (PortalMenuTree portalMenuTree : childrenList) {
            portalMenuTree.setChildrenList(builderChildrenMenu(portalMenuTree.getMenuId(), portalMenuVOList));
        }
        if (childrenList.size() == 0) {
            return new ArrayList<>();
        }
        childrenList = childrenList.stream().sorted(Comparator.comparing(PortalMenuTree::getMenuSort)).collect(Collectors.toList());
        return childrenList;
    }

}
