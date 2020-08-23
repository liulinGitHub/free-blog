package com.blog.core.system.dict.service;

import com.blog.core.system.dict.vo.ManageDictDataVO;

import java.util.List;

/**
 * @Description: 数据字典数据Service
 * @date: 2020/8/23 18:14
 * @author: 950103
 * @version: 1.0
 */
public interface ManageDictDataService {

    List<ManageDictDataVO> queryManageDictDataDetails(String dictId);

    List<ManageDictDataVO> queryManageDictDataByFieldType(String fieldType);

    void deleteManageDictData(String dictDataId);
}
