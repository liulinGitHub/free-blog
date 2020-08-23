package com.blog.core.system.dict.service;

import com.blog.core.system.dict.dto.ManageDictAddDTO;
import com.blog.core.system.dict.dto.ManageDictEditDTO;
import com.blog.core.system.dict.vo.ManageDictVO;

import java.util.List;

/**
 * @Description: 数据字典Service
 * @date: 2020/8/23 16:42
 * @author: 950103
 * @version: 1.0
 */
public interface ManageDictService {

    List<ManageDictVO> queryManageDictByPage();

    ManageDictVO queryManageDictByDictId(String dictId);

    void addManageDict(ManageDictAddDTO manageDictAddDTO);

    void editManageDict(ManageDictEditDTO manageDictEditDTO);

    void deleteManageDict(String dictId);
}
