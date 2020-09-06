package com.blog.core.system.dict.dao;

import com.blog.core.system.dict.vo.ManageDictDataVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 数据字典数据Mapper
 * @date: 2020/8/23 18:17
 * @author: 950103
 * @version: 1.0
 */
@Repository("manageDictDataMapper")
public interface ManageDictDataMapper {

    List<ManageDictDataVO> selectManageDictDataDetails(String dictId);

    List<ManageDictDataVO> selectManageDictDataByFieldType(String fieldType);

    int deleteManageDictData(String dictDataId);
}
