package com.blog.core.system.menu.entity;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.enums.MenuTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 菜单
 * @Author: 950103
 * @Date: 2020/2/8 20:29
 * @version: 1.0
 **/
@Data
public class ManageMenu {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("菜单父ID")
    private String parentId;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer menuSort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private MenuTypeEnum type;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;

    @ApiModelProperty("创建人")
    private Integer createId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人")
    private Integer updateId;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("标识菜单是前端还是后台")
    private String isWeb;

    @ApiModelProperty("父菜单名称")
    private String parentName;
}
