package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ReleaseStatusEnum
 * @description: 文章发布状态枚举
 * @author: 950103
 * @create: 2019-05-27 17:35
 * @Version: 1.0
 */
public enum ReleaseStatusEnum implements BaseEnum {

    RELEASE_NO("0", "未发布"),
    RELEASE_YES("1", "已发布")
    ;

    private String value;
    private String name;

    ReleaseStatusEnum(String value, String name) {
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
