package com.blog.core.system.dept.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.dept.dao.ManageDeptMapper;
import com.blog.core.system.dept.dto.ManageDeptAddDTO;
import com.blog.core.system.dept.dto.ManageDeptEditDTO;
import com.blog.core.system.dept.dto.MangeDeptTree;
import com.blog.core.system.dept.entity.ManageDept;
import com.blog.core.system.dept.service.ManageDeptService;
import com.blog.core.system.dept.vo.ManageDeptListVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @description: 部门service实现类
 * @Author: 950103
 * @Date: 2020/3/31 14:54
 * @version: 1.0
 **/
@Service
public class ManageDeptServiceImpl implements ManageDeptService {

    @Autowired
    private ManageDeptMapper manageDeptMapper;

    @Override
    public List<ManageDeptListVO> queryManageDeptByPage() {
        return null;
    }

    @Override
    public List<MangeDeptTree> builderDeptTree() {
        // 根据当前用户查询用户所有的部门
        Integer userId = SecurityUtils.getUser().getUserId();
        List<MangeDeptTree> mangeDeptTreeList = new ArrayList<>();
        List<MangeDeptTree> manageDeptListVOS = this.manageDeptMapper.selectManageDeptByUserId(userId);
        if (CollectionUtils.isNotEmpty(manageDeptListVOS)) {
            for (MangeDeptTree mangeDeptTree : manageDeptListVOS) {
                if (Objects.nonNull(mangeDeptTree.getParentId())) {
                    mangeDeptTreeList.add(mangeDeptTree);
                }
                for (MangeDeptTree deptListVO : manageDeptListVOS) {
                    if (mangeDeptTree.getDeptId().equals(deptListVO.getParentId())) {
                        if (CollectionUtils.isEmpty(mangeDeptTree.getChildren())) {
                            mangeDeptTree.setChildren(new ArrayList<>());
                        }
                        mangeDeptTree.getChildren().add(deptListVO);
                    }
                }
            }
        }
        return mangeDeptTreeList;
    }

    @Transactional
    @Override
    public void addManageDept(ManageDeptAddDTO manageDeptAddDTO) {
        Integer userId = SecurityUtils.getUserId();
        ManageDept manageDept = MapperUtils.mapperBean(manageDeptAddDTO, ManageDept.class);
        manageDept.setEnable(EnableEnum.Enable_YES);
        manageDept.setCreateId(userId);
        manageDept.setCreateTime(new Date());
        this.manageDeptMapper.insertManageDept(manageDept);
    }

    @Transactional
    @Override
    public void editManageDept(ManageDeptEditDTO manageDeptEditDTO) {
        Integer userId = SecurityUtils.getUserId();
        ManageDept manageDept = MapperUtils.mapperBean(manageDeptEditDTO, ManageDept.class);
        manageDept.setUpdateId(userId);
        manageDept.setUpdateTime(new Date());
        this.manageDeptMapper.updateManageDept(manageDept);
    }
}
