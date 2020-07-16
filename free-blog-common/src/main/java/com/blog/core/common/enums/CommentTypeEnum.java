package com.blog.core.common.enums;

/**
 * @ClassNmae: CommentBelongTypeEnum
 * @description: 评论类型
 * @Author: 950103
 * @Date: 2020/2/6 17:27
 **/
public enum CommentTypeEnum implements BaseEnum {

    ARTICLE("0", "文章");

    private String value;
    private String name;

    CommentTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
