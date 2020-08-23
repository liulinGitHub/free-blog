package com.blog.core.article.dao;


import com.blog.core.article.entity.PortalArticle;
import com.blog.core.article.vo.PortalArticleDetailsVO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.vo.PortalArticleListVO;
import com.blog.core.common.enums.EnableEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: PortalArticleMapper
 * @Description: 文章信息Mapper
 * @Author: 950103
 * @Date: 2020/4/19 21:20
 * @Version 1.0
 */
@Repository("portalArticleMapper")
public interface PortalArticleMapper {

    /**
     * 查询文章信息
     *
     * @return
     */
    List<PortalArticleListVO> selectArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    PortalArticleDetailsVO selectArticleByArticleId(String articleId);

    /**
     * 修改阅读文章量
     *
     * @param articleId
     * @return
     */
    void updateReadArticleByArticleId(String articleId);

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
     * @param enableEnum
     * @return
     */
    int deletePortalArticleDraft(@Param("articleId") String articleId, @Param("EnableEnum") EnableEnum enableEnum);

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
    int insertPortalArticleDraft(PortalArticle article);

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

    int insert(PortalArticle portalArticle);
}
