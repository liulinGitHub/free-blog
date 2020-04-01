package com.blog.core.common.enums;

/**
 * @ClassNmae: CategoryBelongTypeEnum
 * @description: 分类所属类型枚举
 * @Author: liulin
 * @Date: 2020/2/9 19:45
 **/
public enum CategoryBelongTypeEnum implements BaseEnum {

    ARTICLE("2", "文章");

    private String value;
    private String name;

    CategoryBelongTypeEnum(String value, String name) {
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
