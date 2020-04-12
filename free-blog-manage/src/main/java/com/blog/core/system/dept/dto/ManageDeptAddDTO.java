package com.blog.core.system.dept.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageDeptAddDTO
 * @description: 部门添加参数
 * @Author: liulin
 * @Date: 2020/4/12 18:21
 **/
@Data
public class ManageDeptAddDTO {

    @ApiModelProperty("部门上级id")
    private String parentId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
