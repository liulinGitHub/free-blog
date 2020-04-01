package com.blog.core.common.enums;

/**
 * @ClassNmae: CommentBelongTypeEnum
 * @description: 评论所属类型
 * @Author: liulin
 * @Date: 2020/2/6 17:27
 **/
public enum  CommentBelongTypeEnum implements BaseEnum {

    ARTICLE("2", "文章");

    private String value;
    private String name;

    CommentBelongTypeEnum(String value, String name) {
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
