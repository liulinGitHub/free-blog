package com.blog.core.system.job.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 岗位添加参数
 * @Author: 950103
 * @Date: 2020/4/12 18:19
 * @version: 1.0
 **/
@Data
public class ManageJobAddDTO {

    @ApiModelProperty("岗位名称")
    private String jobName;

    @ApiModelProperty("部门id")
    private Integer deptId;
}
