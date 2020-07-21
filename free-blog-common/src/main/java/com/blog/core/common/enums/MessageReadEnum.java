package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: MessageReadEnum
 * @description: 消息阅读枚举
 * @author: 950103
 * @create: 2019-05-16 10:48
 * @Version: 1.0
 */
public enum  MessageReadEnum implements BaseEnum {

    MESSAGE_READ_YES("1", "已读"),
    MESSAGE_READ_NO("0", "未读");

    private String value;
    private String name;

    MessageReadEnum(String value, String name) {
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
