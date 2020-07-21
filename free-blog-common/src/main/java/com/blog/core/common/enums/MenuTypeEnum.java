package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: MenuTypeEnum
 * @description: 菜单类型枚举
 * @author: 950103
 * @create: 2019-06-29 09:49
 * @Version: 1.0
 */
public enum MenuTypeEnum implements BaseEnum {

    CATALOG("0","目录"),
    MENU("1", "菜单"),
    BUTTON("2", "按钮");

    private String value;
    private String name;

    MenuTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @JsonCreator
    @Override
    public String toString() {
        return value;
    }

    @Override
	public String getName() {
        return name;
    }

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }
}
