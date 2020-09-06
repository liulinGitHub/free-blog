package com.blog.core.system.job.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.job.dao.ManageJobMapper;
import com.blog.core.system.job.dto.ManageJobAddDTO;
import com.blog.core.system.job.dto.ManageJobEditDTO;
import com.blog.core.system.job.entity.ManageJob;
import com.blog.core.system.job.service.ManageJobService;
import com.blog.core.system.job.vo.ManageJobListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description: 岗位service实现类
 * @author: 950103
 * @create_time: 2020/4/12 17:24
 * @version: 1.0
 **/
@Service
public class ManageJobServiceImpl implements ManageJobService {

    @Autowired
    private ManageJobMapper manageJobMapper;

    @Override
    public List<ManageJobListVO> queryManageJobByPage() {
        List<ManageJobListVO> manageJobListVOList = this.manageJobMapper.selectManageJobByPage();
        return manageJobListVOList;
    }

    @Transactional
    @Override
    public void addManageJob(ManageJobAddDTO manageJobAddDTO) {
        Integer userId = SecurityUtils.getUserId();
        ManageJob manageJob = MapperUtils.mapperBean(manageJobAddDTO, ManageJob.class);
        manageJob.setEnable(EnableEnum.Enable_YES);
        manageJob.setCreateId(userId);
        manageJob.setCreateTime(new Date());
        this.manageJobMapper.insertManageJob(manageJob);
    }

    @Transactional
    @Override
    public void editManageJob(ManageJobEditDTO manageJobEditDTO) {
        Integer userId = SecurityUtils.getUserId();
        ManageJob manageJob = MapperUtils.mapperBean(manageJobEditDTO, ManageJob.class);
        manageJob.setUpdateId(userId);
        manageJob.setUpdateTime(new Date());
        this.manageJobMapper.updateManageJob(manageJob);
    }
}
