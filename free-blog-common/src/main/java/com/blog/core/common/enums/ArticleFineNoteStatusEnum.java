package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: ArticleFineNoteStatusEnum
 * @description: 文章是否精帖状态
 * @Author: liulin
 * @Date: 2020/2/10 16:41
 **/
public enum ArticleFineNoteStatusEnum implements BaseEnum{

    FINE_NOTE_NO("0", "不是精帖"),
    FINE_NOTE_YES("1", "是精帖")
    ;

    private String value;
    private String name;

    ArticleFineNoteStatusEnum(String value, String name) {
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
