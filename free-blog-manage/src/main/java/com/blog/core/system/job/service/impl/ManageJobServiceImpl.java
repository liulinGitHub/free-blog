package com.blog.core.system.job.service.impl;

import com.blog.core.common.enums.IsEnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.PrimarykeyUtil;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.dept.entity.ManageDept;
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
 * @ClassNmae: ManageJobServiceImpl
 * @description: 岗位service实现类
 * @Author: liulin
 * @Date: 2020/4/12 17:24
 **/
@Service
public class ManageJobServiceImpl implements ManageJobService {

    @Autowired
    private ManageJobMapper manageJobMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Override
    public List<ManageJobListVO> queryManageJobByPage() {
        return null;
    }

    @Transactional
    @Override
    public void addManageJob(ManageJobAddDTO manageJobAddDTO) {
        String userId = SecurityUtils.getUserId();
        ManageJob manageJob = MapperUtils.mapperBean(manageJobAddDTO, ManageJob.class);
        manageJob.setJobId(primarykeyUtil.getPimaryKey());
        manageJob.setIsEnable(IsEnableEnum.Enable_YES);
        manageJob.setCreateId(userId);
        manageJob.setCreateTime(new Date());
        this.manageJobMapper.insertManageJob(manageJob);
    }

    @Transactional
    @Override
    public void editManageJob(ManageJobEditDTO manageJobEditDTO) {
        String userId = SecurityUtils.getUserId();
        ManageJob manageJob = MapperUtils.mapperBean(manageJobEditDTO, ManageJob.class);
        manageJob.setUpdateId(userId);
        manageJob.setUpdateTime(new Date());
        this.manageJobMapper.updateManageJob(manageJob);
    }
}
