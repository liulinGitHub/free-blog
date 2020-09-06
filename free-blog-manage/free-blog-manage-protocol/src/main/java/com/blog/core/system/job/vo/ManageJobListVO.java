package com.blog.core.system.job.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 岗位
 * @Author: 950103
 * @Date: 2020/4/12 17:24
 * @version: 1.0
 **/
@Data
public class ManageJobListVO {

    @ApiModelProperty("岗位id")
    private Integer jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;
}
