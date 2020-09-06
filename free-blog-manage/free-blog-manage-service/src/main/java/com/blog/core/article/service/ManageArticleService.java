package com.blog.core.article.service;

import com.blog.core.article.vo.ManageArticleListVO;
import com.blog.core.article.vo.ManageArticleVO;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2019-11-22 14:50
 * @Version: 1.0
 */
public interface ManageArticleService {

    /**
     * 分页查询文章信息
     *
     * @return
     */
    List<ManageArticleListVO> queryManageArticleByPage();

    /**
     * 查看文章信息详情
     *
     * @param articleId
     * @return
     */
    ManageArticleVO queryManageArticleByArticleId(Integer articleId);

    /**
     * 文章审核通过，并且发表文章，并且通知文章作者
     *
     * @param articleId
     */
    void checkManageArticle(Integer articleId);
}
