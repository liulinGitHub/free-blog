package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: PortalMenuTree
 * @description: 菜单树
 * @author: 950103
 * @create: 2019-06-29 10:54
 * @Version: 1.0
 */
@Data
public class PortalMenuTree {

    @ApiModelProperty("菜单ID")
    private String menuId;

    @ApiModelProperty("父菜单ID")
    private String parentId;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer menuSort;

    @ApiModelProperty("菜单或按钮(0 :菜单，1：按钮)")
    private String menuType;

    @ApiModelProperty("子菜单")
    private List<PortalMenuTree> childrenList;
}
