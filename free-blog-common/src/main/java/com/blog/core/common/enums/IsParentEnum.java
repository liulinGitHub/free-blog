package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @program: IsParentEnum
 * @description: 是否是父级
 * @author: liulin
 * @create: 2019-05-15 11:45
 * @Version: 1.0
 */
public enum IsParentEnum implements BaseEnum {

    PARENT_YES("1", "是"),
    PARENT_NO("0", "否");

    private String value;
    private String name;

    IsParentEnum(String value, String name) {
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
