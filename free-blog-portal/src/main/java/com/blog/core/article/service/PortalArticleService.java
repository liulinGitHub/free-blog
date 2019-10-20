package com.blog.core.article.service;


import com.blog.core.article.entity.dto.PortalArticleCheckDTO;
import com.blog.core.article.entity.vo.PortalArticleInfoVO;
import java.util.List;

public interface PortalArticleService {

    /**
     * 分页查询文章信息
     *
     * @return
     */
    List<PortalArticleInfoVO> queryArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    PortalArticleInfoVO findArticleById(String articleId);

    /**
     * 提交审核
     *
     * @param portalArticleCheckDTO
     */
    void submitCheckArticle(PortalArticleCheckDTO portalArticleCheckDTO);

    /**
     * 保存文章草稿
     *
     * @param portalArticleCheckDTO
     */
    void saveDraft(PortalArticleCheckDTO portalArticleCheckDTO);

    /**
     * 删除文章草稿
     *
     * @param articleId
     */
    void deleteDraft(String articleId);

    /**
     * 文章审核通过，并且发表文章，并且通知文章作者
     *
     * @param articleId
     */
    void checkArticle(String articleId);

    /**
     * 文章点赞
     *
     * @param articleId
     * @return
     */
    void updateApproves(String articleId);

    /**
     * 增加评论数
     *
     * @param articleId
     * @return
     */
    void updateComments(String articleId);

    /**
     * 文章热度修改
     *
     * @param articleId
     */
    void updateTemperature(String articleId);

}
