package com.blog.core.system.dept.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @ClassNmae: MangeDeptTree
 * @description: 部门树
 * @Author: liulin
 * @Date: 2020/4/12 18:05
 **/
@Data
public class MangeDeptTree {

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("部门上级id")
    private String parentId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MangeDeptTree> children;

}
