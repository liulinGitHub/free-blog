package com.blog.core.system.dept.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 部门实体参数
 * @Author: 950103
 * @Date: 2020/4/12 18:25
 * @version: 1.0
 **/
@Data
public class ManageDept extends BaseModel {

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("部门上级id")
    private Integer parentId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;
}
