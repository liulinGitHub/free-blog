package com.blog.core.system.dept.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassNmae: ManageDept
 * @description: 部门实体参数
 * @Author: liulin
 * @Date: 2020/4/12 18:25
 **/
@Data
public class ManageDept extends BaseModel {

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("部门上级id")
    private String parentId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;
}
