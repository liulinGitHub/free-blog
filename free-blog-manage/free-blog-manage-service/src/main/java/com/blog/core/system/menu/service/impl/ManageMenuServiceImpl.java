package com.blog.core.system.menu.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.menu.dao.ManageMenuMapper;
import com.blog.core.system.menu.dto.ManageMenuAddDTO;
import com.blog.core.system.menu.dto.ManageMenuEditDTO;
import com.blog.core.system.menu.entity.ManageMenu;
import com.blog.core.system.menu.entity.ManageMenuTree;
import com.blog.core.system.menu.service.ManageMenuService;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuMetaVO;
import com.blog.core.system.menu.vo.ManageMenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
public class ManageMenuServiceImpl implements ManageMenuService {

    @Autowired
    private ManageMenuMapper manageMenuMapper;

    @Override
    public List<ManageMenuListVO> queryManageMenuAll() {
        return this.manageMenuMapper.selectManageMenuAll();
    }

    @Override
    public List<ManageMenuListVO> queryBuildManageMenu() {
        SecurityUser currentUser = SecurityUtils.getUser();
        List<ManageMenuListVO> manageMenuListVOS = new ArrayList<>();
        manageMenuListVOS = this.manageMenuMapper.selectBuildManageMenuByUserId(currentUser.getUserId());
        return manageMenuListVOS;
    }

    @Override
    public List<ManageMenuTree> buildMenus(List<ManageMenuListVO> manageMenuListVOList){
        if (CollectionUtils.isEmpty(manageMenuListVOList)) {
            return new ArrayList<>();
        }
        List<ManageMenuTree> manageMenuTreeList = new ArrayList<>();
        manageMenuListVOList.forEach(manageMenuListVO -> {
            List<ManageMenuListVO> children = manageMenuListVO.getChildren();
            ManageMenuTree manageMenuTree = new ManageMenuTree(manageMenuListVO);
            manageMenuTree.setMeta(new ManageMenuMetaVO(manageMenuListVO.getName(),manageMenuListVO.getIcon(),!manageMenuListVO.getCache()));
            if (CollectionUtils.isNotEmpty(children)) {
                manageMenuTree.setAlwaysShow(true);
                manageMenuTree.setRedirect("noredirect");
                manageMenuTree.setChildren(buildMenus(children));
            } else if (StringUtils.isEmpty(manageMenuListVO.getParentId())) {
                ManageMenuTree parentMenuTree = new ManageMenuTree();
                if(!manageMenuListVO.getIFrame()){
                    parentMenuTree.setPath("index");
                    parentMenuTree.setName(manageMenuListVO.getName());
                    parentMenuTree.setComponent(manageMenuListVO.getComponent());
                } else {
                    parentMenuTree.setPath(manageMenuListVO.getPath());
                }
                manageMenuTree.setName(null);
                manageMenuTree.setMeta(null);
                manageMenuTree.setComponent("Layout");
                manageMenuTree.setChildren(Collections.singletonList(parentMenuTree));
            }
            manageMenuTreeList.add(manageMenuTree);
        });
        return manageMenuTreeList;
    }

    @Override
    public List<ManageMenuListVO> buildMenuTree(List<ManageMenuListVO> manageMenuListVOList) {
        if (CollectionUtils.isEmpty(manageMenuListVOList)) {
            return new ArrayList<>();
        }
        List<ManageMenuListVO> trees = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        for (ManageMenuListVO manageMenuListVO : manageMenuListVOList) {
            if (StringUtils.isEmpty(manageMenuListVO.getParentId())) {
                trees.add(manageMenuListVO);
            }
            for (ManageMenuListVO it : manageMenuListVOList) {
                if (StringUtils.isNotBlank(it.getParentId())
                        && it.getParentId().equals(manageMenuListVO.getMenuId())) {
                    if (manageMenuListVO.getChildren() == null) {
                        manageMenuListVO.setChildren(new ArrayList<>());
                    }
                    manageMenuListVO.getChildren().add(it);
                    ids.add(it.getMenuId());
                }
            }
        }
        if(trees.size() == 0){
            trees = manageMenuListVOList.stream().filter(s -> !ids.contains(s.getMenuId())).collect(Collectors.toList());
        }
        return trees;
    }

    @Override
    public ManageMenuVO queryManageMenuByMenuId(Integer menuId) {
        return this.manageMenuMapper.selectManageMenuByMenuId(menuId);
    }

    @Transactional
    @Override
    public void addManageMenu(ManageMenuAddDTO manageMenuAddDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        ManageMenu manageMenu = MapperUtils.mapperBean(manageMenuAddDTO, ManageMenu.class);
        manageMenu.setCreateId(currentUser.getUserId());
        manageMenu.setCreateTime(new Date());
        manageMenu.setEnable(EnableEnum.Enable_YES);
        this.manageMenuMapper.insertManageMenu(manageMenu);
    }

    @Transactional
    @Override
    public void editManageMenu(ManageMenuEditDTO manageMenuEditDTO) {
        SecurityUser currentUser = SecurityUtils.getUser();
        ManageMenu manageMenu = MapperUtils.mapperBean(manageMenuEditDTO, ManageMenu.class);
        manageMenu.setUpdateId(currentUser.getUserId());
        manageMenu.setUpdateTime(new Date());
        this.manageMenuMapper.updateManageMenu(manageMenu);
    }

    @Transactional
    @Override
    public void disableManageMenu(Integer menuId) {
        this.manageMenuMapper.disableManageMenuByByMenuId(menuId);
    }

    @Transactional
    @Override
    public void enableManageMenu(Integer menuId) {
        this.manageMenuMapper.enableManageMenuByMenuId(menuId);
    }

}
