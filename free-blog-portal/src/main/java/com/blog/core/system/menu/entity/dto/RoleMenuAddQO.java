package com.blog.core.system.menu.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: UserRoleAddQO
 * @description: 添加角色菜单信息
 * @author: liulin
 * @create: 2019-06-28 15:04
 * @Version: 1.0
 */
@Data
public class RoleMenuAddQO {

    @ApiModelProperty(value="菜单id")
    private String menuId;

    @ApiModelProperty(value="角色id")
    private String roleId;
}
