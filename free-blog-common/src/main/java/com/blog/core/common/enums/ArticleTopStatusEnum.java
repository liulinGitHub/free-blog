package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: ArticleTopStatusEnum
 * @description: 文章置顶状态枚举
 * @Author: liulin
 * @Date: 2020/2/10 16:30
 **/
public enum ArticleTopStatusEnum implements BaseEnum{

    TOP_NO("0", "未置顶"),
    TOP_YES("2", "已置顶");

    private String value;
    private String name;

    ArticleTopStatusEnum(String value, String name) {
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
