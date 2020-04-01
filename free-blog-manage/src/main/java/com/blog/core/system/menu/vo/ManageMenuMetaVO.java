package com.blog.core.system.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassNmae: ManageMenuMetaVO
 * @description:
 * @Author: liulin
 * @Date: 2020/3/6 12:56
 **/
@Data
@AllArgsConstructor
public class ManageMenuMetaVO {

    private String title;

    private String icon;

    private Boolean noCache;
}
