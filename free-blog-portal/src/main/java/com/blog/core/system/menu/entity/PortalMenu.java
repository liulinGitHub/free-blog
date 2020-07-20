package com.blog.core.system.menu.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.enums.MenuTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalMenu
 * @description:
 * @Author: 950103
 * @Date: 2019/4/18 23:48
 **/
@Data
public class PortalMenu extends BaseModel {

    @ApiModelProperty("菜单code")
    private String menuCode;

    @ApiModelProperty("菜单父Code")
    private String parentCode;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private String menuSort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private MenuTypeEnum menuType;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;

}
