package com.blog.core.system.role.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageRoleListVO
 * @description: 角色信息
 * @Author: liulin
 * @Date: 2020/3/31 12:23
 **/
@Data
public class ManageRoleListVO {

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

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createName;
}
