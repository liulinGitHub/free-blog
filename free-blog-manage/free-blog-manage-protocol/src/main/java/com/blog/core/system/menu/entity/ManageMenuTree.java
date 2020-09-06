package com.blog.core.system.menu.entity;

import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuMetaVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/2/7 16:22
 * @version: 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ManageMenuTree {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("组件名称")
    private String componentName;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("链接地址")
    private String path;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer sort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String type;

    private Boolean alwaysShow;

    private String redirect;

    private ManageMenuMetaVO meta;

    private List<ManageMenuTree> children;

    public ManageMenuTree() {

    }

    public ManageMenuTree(ManageMenuListVO manageMenuListVO) {
        this.menuId = manageMenuListVO.getMenuId();
        this.component = StringUtils.isEmpty(manageMenuListVO.getParentId()) ? "Layout" :manageMenuListVO.getComponent();
        this.componentName = manageMenuListVO.getComponentName();
        this.name = StringUtils.isNotBlank(manageMenuListVO.getComponentName()) ? manageMenuListVO.getComponentName() : manageMenuListVO.getName();
        this.path = StringUtils.isNotBlank(manageMenuListVO.getParentId()) ? manageMenuListVO.getPath() : "/" + manageMenuListVO.getPath();
        this.icon = manageMenuListVO.getIcon();
        this.sort = manageMenuListVO.getSort();
        this.type = manageMenuListVO.getType();
    }
}
