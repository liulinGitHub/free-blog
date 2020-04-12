package com.blog.core.system.dept.dao;

import com.blog.core.system.dept.dto.MangeDeptTree;
import com.blog.core.system.dept.entity.ManageDept;
import com.blog.core.system.dept.vo.ManageDeptListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageDeptMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/4/12 18:08
 **/
@Repository("manageDeptMapper")
public interface ManageDeptMapper {

    List<MangeDeptTree> selectManageDeptByUserId(String userId);

    void insertManageDept(ManageDept manageDept);

    void updateManageDept(ManageDept manageDept);
}
