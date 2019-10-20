package com.blog.core.event;

import com.blog.core.common.event.AbstractEvent;

/**
 * @program: UserArticleEvent
 * @description: 文章审核后置事件
 * @author: liulin
 * @create: 2019-05-27 16:18
 * @Version: 1.0
 */
public class UserArticleEvent extends AbstractEvent<String> {

    public UserArticleEvent(String articleUserId) {
        super(articleUserId);
    }
}
