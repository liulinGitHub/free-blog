package com.blog.core.system.dept.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageDeptEditDTO
 * @description: 部门修改参数
 * @Author: liulin
 * @Date: 2020/4/12 18:21
 **/
@Data
public class ManageDeptEditDTO {

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
