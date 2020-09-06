package com.blog.core.system.dict.dao;

import com.blog.core.system.dict.entity.ManageDict;
import com.blog.core.system.dict.vo.ManageDictVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 数据字典Mapper
 * @date: 2020/8/23 17:09
 * @author: 950103
 * @version: 1.0
 */
@Repository("manageDictMapper")
public interface ManageDictMapper {

    List<ManageDictVO> selectManageDictByPage();

    ManageDictVO selectManageDictByDictId(String dictId);

    int insertManageDict(ManageDict manageDict);

    int updateManageDict(ManageDict manageDict);

    int deleteManageDict(String dictId);
}
