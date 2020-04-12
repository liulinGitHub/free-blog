package com.blog.core.system.job.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageJobEditDTO
 * @description: 岗位修改参数
 * @Author: liulin
 * @Date: 2020/4/12 18:20
 **/
@Data
public class ManageJobEditDTO {

    @ApiModelProperty("岗位id")
    private String jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;
}
