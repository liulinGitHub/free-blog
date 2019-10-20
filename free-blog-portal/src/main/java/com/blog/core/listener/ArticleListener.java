package com.blog.core.listener;

import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.event.ArticleCommentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae: ArticleListener
 * @description: 文章服务监听评论服务后置事件
 * @Author: liulin
 * @Date: 2019/5/11 23:00
 **/
@Slf4j
@Component
public class ArticleListener {

    @Autowired
    private PortalArticleMapper portalArticleMapper;

    /**
     * 添加评论
     * 增加文章评论数 后置事件
     * @param event
     */
    @EventListener
    public void onApplicationEvent(ArticleCommentEvent event) {
        String articleId = event.getSource();
        int result = this.portalArticleMapper.updateComments(articleId);
        if(result < 1){
            log.error("增加评论失败【{}】", articleId);
            throw new RuntimeException("评论失败！");
        }
    }
}
