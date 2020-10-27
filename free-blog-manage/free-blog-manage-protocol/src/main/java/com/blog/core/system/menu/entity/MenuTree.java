package com.blog.core.system.menu.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/2/7 16:22
 * @version: 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuTree {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer sort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String type;

    private List<MenuTree> children = new ArrayList<>();
}
