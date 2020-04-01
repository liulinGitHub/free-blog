package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @program: nbbolg
 * @description: 启用停用枚举
 * @author: liulin
 * @create: 2019-04-27 14:34
 */
public enum  IsEnableEnum implements BaseEnum {

    Enable_NO("0", "停用"),
    Enable_YES("1", "启用");

    private String value;
    private String name;

    IsEnableEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @JsonCreator
    @Override
    public String toString() {
        return value;
    }

    public String getName() {
        return name;
    }

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }
}
