package com.blog.core.system.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: PortalMenuVO
 * @description: 菜单返回前端VO
 * @Author: liulin
 * @Date: 2019/4/18 23:48
 **/
@Data
public class PortalMenuVO {

    @ApiModelProperty("菜单Id")
    private String menuId;

    @ApiModelProperty("菜单父Id")
    private String parentId;

    @ApiModelProperty("菜单名称")
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

    @ApiModelProperty("创建时间")
    private Date createTime;

    private List<PortalMenuVO> menuVOList;
}
