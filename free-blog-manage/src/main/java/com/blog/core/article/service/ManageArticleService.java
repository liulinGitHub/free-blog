package com.blog.core.article.service;

import com.blog.core.article.entity.vo.ManageArticleInfoVO;

import java.util.List;

/**
 * @program: ManageArticleService
 * @description:
 * @author: liulin
 * @create: 2019-11-22 14:50
 * @Version: 1.0
 */
public interface ManageArticleService {

    /**
     * 分页查询文章信息
     *
     * @return
     */
    List<ManageArticleInfoVO> queryArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    ManageArticleInfoVO queryArticleByArticleId(String articleId);

    /**
     * 文章审核通过，并且发表文章，并且通知文章作者
     *
     * @param articleId
     */
    void checkArticle(String articleId);
}
