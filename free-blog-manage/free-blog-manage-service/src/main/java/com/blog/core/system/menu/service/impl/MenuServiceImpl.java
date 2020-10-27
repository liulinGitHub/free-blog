package com.blog.core.system.menu.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.menu.dao.MenuMapper;
import com.blog.core.system.menu.dto.MenuAddDTO;
import com.blog.core.system.menu.dto.MenuEditDTO;
import com.blog.core.system.menu.entity.Menu;
import com.blog.core.system.menu.entity.MenuTree;
import com.blog.core.system.menu.service.MenuService;
import com.blog.core.system.menu.vo.MenuListVO;
import com.blog.core.system.menu.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 菜单service
 * @author: 950103
 * @create_time: 2020/2/7 16:21
 * @version: 1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuListVO> queryMenuAll() {
        return this.menuMapper.selectMenuAll();
    }

    @Override
    public List<MenuTree> buildMenus() {
        Integer userId = SecurityUtils.getUserId();
        List<MenuListVO> portalMenuVOList = this.menuMapper.selectUserMenuByUserId(userId);
        return this.builderMenuTree(portalMenuVOList);
    }

    private List<MenuTree> builderMenuTree(List<MenuListVO> menuListVOList) {
        if (CollectionUtils.isEmpty(menuListVOList)) {
            return new ArrayList<>();
        }
        List<MenuListVO> prentMenuList = menuListVOList.parallelStream()
                .filter(MenuListVO -> Objects.isNull(MenuListVO.getParentId()))
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(prentMenuList) && prentMenuList.size() > 0) {
            prentMenuList = prentMenuList.stream().sorted(Comparator.comparing(MenuListVO::getSort)).collect(Collectors.toList());
            List<MenuTree> menuTreeList = new ArrayList<>(prentMenuList.size());
            for (MenuListVO prentMenu : prentMenuList) {
                MenuTree menuTree = MapperUtils.mapperBean(prentMenu, MenuTree.class);
                for (MenuListVO portalMenuVO : menuListVOList) {
                    if (Objects.nonNull(portalMenuVO.getParentId()) && portalMenuVO.getParentId().equals(prentMenu.getMenuId())) {
                        List<MenuTree> childrenList = this.builderChildrenMenu(prentMenu.getMenuId(), menuListVOList);
                        menuTree.setChildren(childrenList);
                    }
                }
                menuTreeList.add(menuTree);
            }
            return menuTreeList;
        }
        return new ArrayList<>();
    }

    /**
     * 构建子菜单
     *
     * @param menuId
     * @param menuListVOList
     * @return
     */
    private List<MenuTree> builderChildrenMenu(Integer menuId, List<MenuListVO> menuListVOList) {
        List<MenuTree> childrenList = new ArrayList();
        for (MenuListVO menuListVO : menuListVOList) {
            if (Objects.nonNull(menuListVO.getParentId()) && menuListVO.getParentId().equals(menuId)) {
                MenuTree menuTree = MapperUtils.mapperBean(menuListVO, MenuTree.class);
                childrenList.add(menuTree);
            }
        }
        for (MenuTree menuTree : childrenList) {
            menuTree.setChildren(builderChildrenMenu(menuTree.getMenuId(), menuListVOList));
        }
        if (childrenList.size() == 0) {
            return new ArrayList<>();
        }
        childrenList = childrenList.stream().sorted(Comparator.comparing(MenuTree::getSort)).collect(Collectors.toList());
        return childrenList;
    }

    @Override
    public MenuVO queryMenuByMenuId(Integer menuId) {
        return menuMapper.selectMenuByMenuId(menuId);
    }

    @Transactional
    @Override
    public void addMenu(MenuAddDTO menuAddDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        Menu menu = MapperUtils.mapperBean(menuAddDTO, Menu.class);
        menu.setCreateId(currentUser.getUserId());
        menu.setCreateTime(new Date());
        menu.setEnable(EnableEnum.Enable_YES);
        menuMapper.insertMenu(menu);
    }

    @Transactional
    @Override
    public void editMenu(MenuEditDTO menuEditDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        Menu menu = MapperUtils.mapperBean(menuEditDTO, Menu.class);
        menu.setUpdateId(currentUser.getUserId());
        menu.setUpdateTime(new Date());
        menuMapper.updateMenu(menu);
    }

    @Transactional
    @Override
    public void disableMenu(Integer menuId) {
        this.menuMapper.disableMenuByByMenuId(menuId);
    }

    @Transactional
    @Override
    public void enableMenu(Integer menuId) {
        this.menuMapper.enableMenuByMenuId(menuId);
    }

}
