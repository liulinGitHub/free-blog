package com.blog.core.system.job.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.IsEnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassNmae: ManageJob
 * @description: 岗位实体参数
 * @Author: liulin
 * @Date: 2020/4/12 18:25
 **/
@Data
public class ManageJob extends BaseModel {

    @ApiModelProperty("岗位id")
    private String jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("启用/停用")
    private IsEnableEnum isEnable;
}
