package com.blog.core.system.dept.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 部门树
 * @Author: 950103
 * @Date: 2020/4/12 18:05
 * @version: 1.0
 **/
@Data
public class MangeDeptTree {

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("部门上级id")
    private Integer parentId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MangeDeptTree> children;

}
