package com.blog.core.system.role.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassNmae: PortalRole
 * @description: 角色
 * @Author: 950103
 * @Date: 2019/4/18 23:48
 **/
@AllArgsConstructor
@Data
public class PortalRole extends BaseModel {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty("角色描述")
    private String roleDescribe;

    @ApiModelProperty("启用/停用")
    private EnableEnum isEnable;
}
