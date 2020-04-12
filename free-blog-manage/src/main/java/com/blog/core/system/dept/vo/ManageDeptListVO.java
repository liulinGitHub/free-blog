package com.blog.core.system.dept.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageDeptListVO
 * @description: 部门VO
 * @Author: liulin
 * @Date: 2020/3/31 14:53
 **/
@Data
public class ManageDeptListVO {

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("部门上级id")
    private String parentId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
