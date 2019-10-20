package com.blog.core.article.dao;


import com.blog.core.article.entity.domain.PortalArticle;
import com.blog.core.article.entity.vo.PortalArticleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("portalArticleMapper")
public interface PortalArticleMapper {

    /**
     * 查询文章信息
     *
     * @return
     */
    List<PortalArticleInfoVO> selectArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    PortalArticleInfoVO findArticleById(String articleId);

    /**
     * 修改阅读文章量
     *
     * @param articleId
     * @return
     */
    void updateReadArticle(String articleId);

    /**
     * 文章点赞
     *
     * @param articleId
     * @return
     */
    int updateApproves(String articleId);

    /**
     * 增加评论数
     *
     * @param articleId
     * @return
     */
    int updateComments(String articleId);

    /**
     * 删除文章草稿
     *
     * @param articleId
     * @return
     */
    int deleteDraft(String articleId);

    /**
     * 文章已经升温
     *
     * @param articleId
     * @return
     */
    int updateTemperature(String articleId);

    /**
     * 保存草稿
     *
     * @param article
     * @return
     */
    int saveDraft(PortalArticle article);

    /**
     * 文章审核
     *
     * @param article
     * @return
     */
    int checkArticle(PortalArticle article);

    /**
     * 提交审核
     *
     * @param article
     * @return
     */
    int submitCheckArticle(PortalArticle article);
}
