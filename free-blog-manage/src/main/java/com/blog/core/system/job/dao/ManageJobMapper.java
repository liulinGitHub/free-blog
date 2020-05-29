package com.blog.core.system.job.dao;

import com.blog.core.system.job.entity.ManageJob;
import com.blog.core.system.job.vo.ManageJobListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageJobMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/4/12 19:23
 **/
@Repository("manageJobMapper")
public interface ManageJobMapper {

    List<ManageJobListVO> selectManageJobByPage();

    void insertManageJob(ManageJob manageJob);

    void updateManageJob(ManageJob manageJob);
}
