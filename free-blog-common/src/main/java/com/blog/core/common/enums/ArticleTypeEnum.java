package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: ArticleTypeEnum
 * @description: 文章类型枚举
 * @Author: liulin
 * @Date: 2020/2/10 16:26
 **/
public enum  ArticleTypeEnum implements BaseEnum{

    TECHNOLOGY_SHARE("0", "技术分享");

    private String value;
    private String name;

    ArticleTypeEnum(String value, String name) {
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
