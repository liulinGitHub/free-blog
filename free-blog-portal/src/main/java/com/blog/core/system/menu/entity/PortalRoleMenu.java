package com.blog.core.system.menu.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalRoleMenu
 * @description: 角色菜单关联信息
 * @author: 950103
 * @create: 2019-06-28 15:54
 * @Version: 1.0
 */
@Data
public class PortalRoleMenu extends BaseModel {

    @ApiModelProperty("角色ID")
    private String roleMenuId;

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("菜单Code")
    private String menuCode;
}
