package com.blog.core.system.job.dao;

import com.blog.core.system.job.entity.ManageJob;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae: ManageJobMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/4/12 19:23
 **/
@Repository("manageJobMapper")
public interface ManageJobMapper {

    void insertManageJob(ManageJob manageJob);

    void updateManageJob(ManageJob manageJob);
}
