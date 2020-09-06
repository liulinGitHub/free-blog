package com.blog.core.system.job.service;

import com.blog.core.system.job.dto.ManageJobAddDTO;
import com.blog.core.system.job.dto.ManageJobEditDTO;
import com.blog.core.system.job.vo.ManageJobListVO;

import java.util.List;

/**
 * @description: 岗位service
 * @author: 950103
 * @create_time: 2020/4/12 17:24
 * @version: 1.0
 **/
public interface ManageJobService {

    List<ManageJobListVO> queryManageJobByPage();

    void addManageJob(ManageJobAddDTO manageJobAddDTO);

    void editManageJob(ManageJobEditDTO manageJobEditDTO);
}
