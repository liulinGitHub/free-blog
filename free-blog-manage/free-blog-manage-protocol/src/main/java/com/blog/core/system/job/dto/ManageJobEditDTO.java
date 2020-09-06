package com.blog.core.system.job.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 岗位修改参数
 * @Author: 950103
 * @Date: 2020/4/12 18:20
 * @version: 1.0
 **/
@Data
public class ManageJobEditDTO {

    @ApiModelProperty("岗位id")
    private Integer jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;
}
