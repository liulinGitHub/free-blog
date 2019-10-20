package com.blog.core.event;

import com.blog.core.common.event.AbstractEvent;

/**
 * @ClassNmae: ArticleCommentEvent
 * @description: 评论事件
 * @Author: liulin
 * @Date: 2019/5/11 22:56
 **/

public class ArticleCommentEvent extends AbstractEvent<String> {

    public ArticleCommentEvent(String articleId) {
        super(articleId);
    }
}
