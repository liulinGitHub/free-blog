package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: AuditStatusEnum
 * @Description: 审核状态 0 未审核 2 审核中 4 已审核
 * @date: 2020/7/20 1:00
 * @author: 950103
 * @Version 1.0
 */
public enum AuditStatusEnum implements BaseEnum {

    AUDIT_NO("0", "未审核"),
    AUDIT_IN("1", "审核中"),
    AUDIT_YES("1", "审核中"),
    ;

    private String value;
    private String name;

    AuditStatusEnum(String value, String name) {
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
