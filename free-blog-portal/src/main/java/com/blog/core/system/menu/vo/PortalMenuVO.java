package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @ClassNmae: SysBaseRole
 * @description: 菜单返回前端VO
 * @Author: liulin
 * @Date: 2019/4/18 23:48
 **/
@Data
public class PortalMenuVO {

    @ApiModelProperty("菜单ID")
    private String menuId;

    @ApiModelProperty("菜单父ID")
    private String parentId;

    @ApiModelProperty(value="菜单名称")
    private String menuName;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private Integer menuSort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private String menuType;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("启用/停用")
    private String isEnable;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("标识菜单是前端还是后台")
    private String isWeb;

    /**
     * 父菜单名称
     */
    private String parentName;

    private List<PortalMenuVO> menuVOList;
}
