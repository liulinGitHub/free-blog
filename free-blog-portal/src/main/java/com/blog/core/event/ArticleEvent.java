package com.blog.core.event;

import com.blog.core.common.event.AbstractEvent;

/**
 * @program: ArticleEvent
 * @description:
 * @author: liulin
 * @create: 2019-05-15 11:56
 * @Version: 1.0
 */
public class ArticleEvent extends AbstractEvent<String> {

    public ArticleEvent(String articleId) {
        super(articleId);
    }
}