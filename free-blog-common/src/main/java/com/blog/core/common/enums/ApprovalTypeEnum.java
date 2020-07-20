package com.blog.core.common.enums;

/**
 * @ClassName: ArticleApprovalEnum
 * @description: 点赞枚举
 * @Author: 950103
 * @Date: 2020/3/25 11:15
 **/

public enum ApprovalTypeEnum {

    APPROVAL_ARTICLE("文章点赞"),
    LIKED_ARTICLE_REPORT("文章点赞统计"),
    APPROVAL_COMMENT("文章评论"),
    LIKED_COMMENT_REPORT("文章评论统计"),
    ;

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
