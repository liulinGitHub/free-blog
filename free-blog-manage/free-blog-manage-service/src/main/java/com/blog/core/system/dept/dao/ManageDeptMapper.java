package com.blog.core.system.dept.dao;

import com.blog.core.system.dept.dto.MangeDeptTree;
import com.blog.core.system.dept.entity.ManageDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/4/12 18:08
 * @version: 1.0
 **/
@Repository("manageDeptMapper")
public interface ManageDeptMapper {

    List<MangeDeptTree> selectManageDeptByUserId(Integer userId);

    void insertManageDept(ManageDept manageDept);

    void updateManageDept(ManageDept manageDept);
}
