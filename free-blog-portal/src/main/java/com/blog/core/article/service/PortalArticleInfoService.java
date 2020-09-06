package com.blog.core.article.service;

import com.blog.core.article.vo.PortalArticleInfoVO;

/**
 * @ClassName: PortalArticleInfoService
 * @Description: 文章相关信息Service
 * @Author: 950103
 * @Date: 2020/4/19 21:13
 * @Version 1.0
 */
public interface PortalArticleInfoService {

    /**
     * 根据文章ID 查询文章相关信息
     *
     * @param articleId
     * @return
     */
    PortalArticleInfoVO queryPortalArticleInfoDetails(Integer articleId);

    /**
     * 添加文章评论数
     * 可以考虑做成异步处理
     *
     * @param articleId
     */
    void editArticleCommentNumber(Integer articleId);
}
