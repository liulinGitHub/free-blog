package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ArticleStatusEnum
 * @description: 文章状态枚举 0,草稿 1 未审核 2 审核通过
 * @author: 950103
 * @create: 2019-05-06 18:12
 * @Version: 1.0
 */
public enum ArticleStatusEnum implements BaseEnum{

    DRAFT("0", "草稿"),
    REVIEW_NO("2", "未审核"),
    REVIEW_IN("4", "审核中"),
    REVIEW_YES("6", "审核通过");

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
