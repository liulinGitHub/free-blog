package com.blog.core.system.dict.service.impl;

import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.PrimarykeyUtil;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.dict.dao.ManageDictMapper;
import com.blog.core.system.dict.dto.ManageDictAddDTO;
import com.blog.core.system.dict.dto.ManageDictEditDTO;
import com.blog.core.system.dict.entity.ManageDict;
import com.blog.core.system.dict.service.ManageDictService;
import com.blog.core.system.dict.vo.ManageDictVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description: 数据字典Service
 * @date: 2020/8/23 17:08
 * @author: 950103
 * @version: 1.0
 */
@Service
public class ManageDictServiceImpl implements ManageDictService {

    @Autowired
    private ManageDictMapper manageDictMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Override
    public List<ManageDictVO> queryManageDictByPage() {
        return this.manageDictMapper.selectManageDictByPage();
    }

    @Override
    public ManageDictVO queryManageDictByDictId(String dictId) {
        return this.manageDictMapper.selectManageDictByDictId(dictId);
    }

    @Transactional
    @Override
    public void addManageDict(ManageDictAddDTO manageDictAddDTO) {
        String userId = SecurityUtils.getUserId();
        ManageDict manageDict = MapperUtils.mapperBean(manageDictAddDTO, ManageDict.class);
        manageDict.setDictId(primarykeyUtil.getPimaryKey());
        manageDict.setCreateId(userId);
        manageDict.setCreateTime(new Date());
        manageDictMapper.insertManageDict(manageDict);
    }

    @Transactional
    @Override
    public void editManageDict(ManageDictEditDTO manageDictEditDTO) {
        String userId = SecurityUtils.getUserId();
        ManageDict manageDict = MapperUtils.mapperBean(manageDictEditDTO, ManageDict.class);
        manageDict.setUpdateId(userId);
        manageDict.setUpdateTime(new Date());
        manageDictMapper.updateManageDict(manageDict);
    }

    @Transactional
    @Override
    public void deleteManageDict(String dictId) {
        manageDictMapper.deleteManageDict(dictId);
    }
}
