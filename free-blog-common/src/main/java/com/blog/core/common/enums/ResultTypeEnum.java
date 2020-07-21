package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ResultTypeEnum
 * @description: 返回结果枚举
 * @author: 950103
 * @create: 2019-05-24 16:41
 * @Version: 1.0
 */
public enum ResultTypeEnum implements BaseEnum {

    SUCCESS("1", "成功"),
    ERROR("0", "失败");

    private String value;
    private String name;

    ResultTypeEnum(String value, String name) {
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
