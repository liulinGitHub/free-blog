package com.blog.core.system.dict.service.impl;

import com.blog.core.system.dict.dao.ManageDictDataMapper;
import com.blog.core.system.dict.service.ManageDictDataService;
import com.blog.core.system.dict.vo.ManageDictDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 数据字典数据Service
 * @date: 2020/8/23 18:16
 * @author: 950103
 * @version: 1.0
 */
@Service
public class ManageDictDataServiceImpl implements ManageDictDataService {

    @Autowired
    private ManageDictDataMapper manageDictDataMapper;

    @Override
    public List<ManageDictDataVO> queryManageDictDataDetails(String dictId) {
        return this.manageDictDataMapper.selectManageDictDataDetails(dictId);
    }

    @Override
    public List<ManageDictDataVO> queryManageDictDataByFieldType(String fieldType) {
        return this.manageDictDataMapper.selectManageDictDataByFieldType(fieldType);
    }

    @Transactional
    @Override
    public void deleteManageDictData(String dictDataId) {
        manageDictDataMapper.deleteManageDictData(dictDataId);
    }
}
