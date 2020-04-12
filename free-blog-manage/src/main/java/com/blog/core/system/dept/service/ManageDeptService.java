package com.blog.core.system.dept.service;

import com.blog.core.system.dept.dto.ManageDeptAddDTO;
import com.blog.core.system.dept.dto.ManageDeptEditDTO;
import com.blog.core.system.dept.dto.MangeDeptTree;
import com.blog.core.system.dept.vo.ManageDeptListVO;

import java.util.List;

/**
 * @ClassNmae: ManageDeptService
 * @description: 部门service
 * @Author: liulin
 * @Date: 2020/3/31 14:53
 **/
public interface ManageDeptService {

    List<ManageDeptListVO> queryManageDeptByPage();

    List<MangeDeptTree> builderDeptTree();

    void addManageDept(ManageDeptAddDTO manageDeptAddDTO);

    void editManageDept(ManageDeptEditDTO manageDeptEditDTO);
}
