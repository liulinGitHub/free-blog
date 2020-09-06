package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/2/7 16:25
 * @version: 1.0
 **/
@Data
public class ManageMenuListVO {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("菜单父ID")
    private String parentId;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("组件名称")
    private String componentName;

    @ApiModelProperty("链接地址")
    private String path;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer sort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String type;

    @ApiModelProperty("权限标识")
    private String permission;

    @ApiModelProperty("是否隐藏")
    private String hidden;

    @ApiModelProperty("是否外链")
    private Boolean IFrame;

    @ApiModelProperty("父菜单名称")
    private String parentName;

    @ApiModelProperty("缓存")
    private Boolean cache;

    @ApiModelProperty("创建时间")
    private Date createTime;

    private List<ManageMenuListVO> children;
}
