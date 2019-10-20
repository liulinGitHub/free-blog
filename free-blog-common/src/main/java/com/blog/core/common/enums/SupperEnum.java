package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @program: SupperEnum
 * @description:
 * @author: liulin
 * @create: 2019-06-29 11:33
 * @Version: 1.0
 */
public enum SupperEnum implements BaseEnum {

    SUPPER("1", "超级管理员"),
    NO_SUPPER("0", "非超级管理员");

    private String value;
    private String name;

    SupperEnum(String value, String name) {
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
