package com.blog.core.article.dao;


import com.blog.core.article.entity.domain.ManageArticle;
import com.blog.core.article.entity.vo.ManageArticleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: ManageArticleMapper
 * @description:
 * @author: liulin
 * @create: 2019-11-22 17:15
 * @Version: 1.0
 */
@Repository("manageArticleMapper")
public interface ManageArticleMapper {

    /**
     * 查询文章信息
     *
     * @return
     */
    List<ManageArticleInfoVO> selectArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    ManageArticleInfoVO selectArticleByArticleId(String articleId);

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
    int saveDraft(ManageArticle article);

    /**
     * 文章审核
     *
     * @param article
     * @return
     */
    int checkArticle(ManageArticle article);

    /**
     * 提交审核
     *
     * @param article
     * @return
     */
    int submitCheckArticle(ManageArticle article);
}
