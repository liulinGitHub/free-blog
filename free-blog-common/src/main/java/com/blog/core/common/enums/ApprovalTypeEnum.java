package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassNmae: ArticleApprovalEnum
 * @description: 文章点赞枚举
 * @Author: liulin
 * @Date: 2020/3/25 11:15
 **/

public enum ApprovalTypeEnum {

    APPROVAL_ARTICLE("文章点赞"),
    LIKED_ARTICLE_REPORT("文章点赞统计");

    private String value;

    ApprovalTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
