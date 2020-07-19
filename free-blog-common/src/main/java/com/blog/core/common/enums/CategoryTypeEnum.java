package com.blog.core.common.enums;

/**
 * @ClassNmae: CategoryTypeEnum
 * @description: 分类类型枚举
 * @Author: 950103
 * @Date: 2020/2/9 19:45
 **/
public enum CategoryTypeEnum implements BaseEnum {

    ARTICLE("0", "文章");

    private String value;
    private String name;

    CategoryTypeEnum(String value, String name) {
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
