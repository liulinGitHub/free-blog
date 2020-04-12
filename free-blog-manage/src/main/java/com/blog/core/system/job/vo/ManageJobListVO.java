package com.blog.core.system.job.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageJobListVO
 * @description: 岗位
 * @Author: liulin
 * @Date: 2020/4/12 17:24
 **/
@Data
public class ManageJobListVO {

    @ApiModelProperty("岗位id")
    private String jobId;

    @ApiModelProperty("岗位名称")
    private String jobName;
}
