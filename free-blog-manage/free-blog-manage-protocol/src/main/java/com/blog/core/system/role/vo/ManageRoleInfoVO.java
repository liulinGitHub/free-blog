package com.blog.core.system.role.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @Author: 950103
 * @Date: 2019/12/22 23:25
 * @version: 1.0
 **/
@Data
public class ManageRoleInfoVO {

    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("角色权限")
    private String rolePermission;
}
