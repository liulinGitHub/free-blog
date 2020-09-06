package com.blog.core.system.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @Author: 950103
 * @Date: 2020/3/6 12:56
 * @version: 1.0
 **/
@Data
@AllArgsConstructor
public class ManageMenuMetaVO {

    private String title;

    private String icon;

    private Boolean noCache;
}
