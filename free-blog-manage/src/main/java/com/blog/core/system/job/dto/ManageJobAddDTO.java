package com.blog.core.system.job.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageJobAddDTO
 * @description: 岗位添加参数
 * @Author: liulin
 * @Date: 2020/4/12 18:19
 **/
@Data
public class ManageJobAddDTO {

    @ApiModelProperty("岗位名称")
    private String jobName;

    @ApiModelProperty("部门id")
    private String deptId;
}
