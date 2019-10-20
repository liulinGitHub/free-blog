package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: MessageTypeEnum
 * @description: 消息类型枚举
 * @Author: liulin
 * @Date: 2019/8/1 23:31
 **/
public enum MessageTypeEnum implements BaseEnum {

    MESSAGE_REPLY("1", "回复"),
    MESSAGE_ART("2", "@"),
    MESSAGE_APPROVAL("3", "赞"),
    MESSAGE_SYSTEM("4", "系统"),
    MESSAGE_SECRET_LETTER("5", "私信"),
    MESSAGE_PERSONAL("6", "我的消息");

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