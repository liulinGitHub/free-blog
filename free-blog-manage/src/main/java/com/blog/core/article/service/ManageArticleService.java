package com.blog.core.article.service;

import com.blog.core.article.vo.ManageArticleListVO;
import com.blog.core.article.vo.ManageArticleVO;

import java.util.List;

/**
 * @ClassName: ManageArticleService
 * @description:
 * @author: 950103
 * @create: 2019-11-22 14:50
 * @Version: 1.0
 */
public interface ManageArticleService {

    /**
     * @Author ll
     * @Description 分页查询文章信息
     * @Date 2020/2/10 17:19
     * @Param []
     * @return java.util.List<com.blog.core.article.vo.ManageArticleListVO>
     **/
    List<ManageArticleListVO> queryManageArticleByPage();

    /**
     * @Author ll
     * @Description 查看文章信息详情
     * @Date 2020/2/10 17:20
     * @Param [articleId]
     * @return com.blog.core.article.vo.ManageArticleVO
     **/
    ManageArticleVO queryManageArticleByArticleId(String articleId);

    /**
     * 文章审核通过，并且发表文章，并且通知文章作者
     *
     * @param articleId
     */
    void checkManageArticle(String articleId);
}
