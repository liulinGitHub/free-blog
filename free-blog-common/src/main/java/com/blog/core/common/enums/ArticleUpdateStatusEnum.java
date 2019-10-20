package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * @program: ArticleUpdateStatusEnum
 * @description: 文章状态修改枚举
 * @author: liulin
 * @create: 2019-07-25 14:49
 * @Version: 1.0
 */
public enum  ArticleUpdateStatusEnum implements BaseEnum{

    ARTICLE_TOP("1", "文章置顶"),
    ARTICLE_PUBLISH("2", "文章发布"),
    ARTICLE_COMMENT("3", "文章评论"),
    ARTICLE_FINE_NOTE("4", "文章精帖"),
    ARTICLE_RECOMMEND("5", "文章推荐");

    private String value;
    private String name;

    ArticleUpdateStatusEnum(String value, String name) {
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
