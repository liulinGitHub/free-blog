package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: ApprovalStatusEnum
 * @description: 点赞状态枚举
 * @Author: liulin
 * @Date: 2020/3/28 14:07
 **/
public enum ApprovalStatusEnum {

    UN_APPROVAL(0.2, "取消赞"),
    APPROVAL(0.4, "点赞");

    private double value;
    private String name;

    ApprovalStatusEnum(double value, String name) {
        this.value = value;
        this.name = name;
    }

    @JsonCreator
    public String toString() {
        return value + "";
    }

    public String getName() {
        return name;
    }

    @JsonValue
    public double getValue() {
        return value;
    }
}
