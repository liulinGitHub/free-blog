package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: MenuTree
 * @description: 返回
 * @author: liulin
 * @create: 2019-06-29 10:54
 * @Version: 1.0
 */
@Data
public class PortalMenuTree {

    @ApiModelProperty("菜单ID")
    private String menuId;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer menuSort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String menuType;

    private List<PortalMenuTree> childs;

    public PortalMenuTree(PortalMenuVO portalMenuVO) {
        this.menuId = portalMenuVO.getMenuId();
        this.webCode = portalMenuVO.getWebCode();
        this.menuName = portalMenuVO.getMenuName();
        this.menuUrl = portalMenuVO.getMenuUrl();
        this.icon = portalMenuVO.getIcon();
        this.menuSort = portalMenuVO.getMenuSort();
        this.menuType = portalMenuVO.getMenuType();
    }
}
