package com.blog.core.system.dept.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 部门修改参数
 * @Author: 950103
 * @Date: 2020/4/12 18:21
 * @version: 1.0
 **/
@Data
public class ManageDeptEditDTO {

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
