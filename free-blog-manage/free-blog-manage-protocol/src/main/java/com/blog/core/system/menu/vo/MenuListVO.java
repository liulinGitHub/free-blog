package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/2/7 16:25
 * @version: 1.0
 **/
@Data
public class MenuListVO {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("菜单父ID")
    private Integer parentId;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer sort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String type;

    @ApiModelProperty("权限标识")
    private String permission;

    private List<MenuListVO> children;
}
