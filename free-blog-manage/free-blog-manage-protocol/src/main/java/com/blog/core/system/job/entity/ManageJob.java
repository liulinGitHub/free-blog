package com.blog.core.system.job.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 岗位实体参数
 * @Author: 950103
 * @Date: 2020/4/12 18:25
 * @version: 1.0
 **/
@Data
public class ManageJob extends BaseModel {

    @ApiModelProperty("岗位id")
    private Integer jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;
}
