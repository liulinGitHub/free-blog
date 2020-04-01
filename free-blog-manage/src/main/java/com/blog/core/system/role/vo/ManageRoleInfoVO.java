package com.blog.core.system.role.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageRoleMenuInfoVO
 * @description:
 * @Author: liulin
 * @Date: 2019/12/22 23:25
 **/
@Data
public class ManageRoleInfoVO {

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("角色权限")
    private String rolePermission;
}
