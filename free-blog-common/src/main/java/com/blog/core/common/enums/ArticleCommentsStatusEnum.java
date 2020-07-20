package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ArticleCommentsStatusEnum
 * @description: 文章是否开启评论枚举
 * @Author: 950103
 * @Date: 2020/2/10 16:31
 **/
public enum ArticleCommentsStatusEnum implements BaseEnum {

    COMMENTS_NO("0", "未开启评论"),
    COMMENTS_YES("2", "开启评论");

    private String value;
    private String name;

    ArticleCommentsStatusEnum(String value, String name) {
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
