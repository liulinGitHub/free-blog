package com.blog.core.system.dept.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 部门VO
 * @Author: 950103
 * @Date: 2020/3/31 14:53
 * @version: 1.0
 **/
@Data
public class ManageDeptListVO {

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("部门上级id")
    private Integer parentId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
