package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: DraftStatusEnum
 * @Description: 是否草稿枚举 0 是草稿 1 不是草稿
 * @date: 2020/7/20 0:58
 * @author: 950103
 * @Version 1.0
 */
public enum DraftStatusEnum implements BaseEnum {

    DRAFT_NO("0", "是草稿"),
    DRAFT_YES("1", "不是草稿");

    private String value;
    private String name;

    DraftStatusEnum(String value, String name) {
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
