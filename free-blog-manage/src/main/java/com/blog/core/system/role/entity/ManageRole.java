package com.blog.core.system.role.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageRole
 * @description: 角色信息
 * @Author: liulin
 * @Date: 2020/4/1 12:35
 **/
@Data
public class ManageRole extends BaseModel {

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescribe;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty("启用/停用")
    private String isEnable;

}
