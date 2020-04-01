package com.blog.core.system.dept.service;

import com.blog.core.system.dept.vo.ManageDeptListVO;

import java.util.List;

/**
 * @ClassNmae: ManageDeptService
 * @description:
 * @Author: liulin
 * @Date: 2020/3/31 14:53
 **/
public interface ManageDeptService {

    List<ManageDeptListVO> queryManageDeptByPage();
}
