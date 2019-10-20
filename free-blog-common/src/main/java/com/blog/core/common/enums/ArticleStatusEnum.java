package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @program: ArticleStatusEnum
 * @description: 文章状态枚举 0,草稿 1 未审核 2 审核通过
 * @author: liulin
 * @create: 2019-05-06 18:12
 * @Version: 1.0
 */
public enum  ArticleStatusEnum implements BaseEnum{

    DRAFT("0", "草稿"),
    CHECK_NO("1", "未审核"),
    CHECK_YES("2", "审核通过");

    private String value;
    private String name;

    ArticleStatusEnum(String value, String name) {
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
