package com.blog.core.system.dept.service;

import com.blog.core.system.dept.dto.ManageDeptAddDTO;
import com.blog.core.system.dept.dto.ManageDeptEditDTO;
import com.blog.core.system.dept.dto.MangeDeptTree;
import com.blog.core.system.dept.vo.ManageDeptListVO;

import java.util.List;

/**
 * @description: 部门service
 * @Author: 950103
 * @Date: 2020/3/31 14:53
 * @version: 1.0
 **/
public interface ManageDeptService {

    List<ManageDeptListVO> queryManageDeptByPage();

    List<MangeDeptTree> builderDeptTree();

    void addManageDept(ManageDeptAddDTO manageDeptAddDTO);

    void editManageDept(ManageDeptEditDTO manageDeptEditDTO);
}
