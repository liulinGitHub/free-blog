package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: MessageTypeEnum
 * @description: 消息类型枚举
 * @Author: 950103
 * @Date: 2019/8/1 23:31
 **/
public enum MessageTypeEnum implements BaseEnum {

    MESSAGE_REPLY("0", "回复"),
    MESSAGE_ART("2", "@"),
    MESSAGE_APPROVAL("4", "赞"),
    MESSAGE_SYSTEM("6", "系统"),
    MESSAGE_SECRET_LETTER("8", "私信"),
    MESSAGE_PERSONAL("10", "我的消息");

    private String value;
    private String name;

    MessageTypeEnum(String value, String name) {
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
