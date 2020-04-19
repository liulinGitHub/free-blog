package com.blog.core.article.service;


import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.vo.PortalArticleDetailsVO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.vo.PortalArticleListVO;

import java.util.List;

public interface PortalArticleService {

    /**
     * 分页查询文章信息
     *
     * @return
     */
    List<PortalArticleListVO> queryArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    PortalArticleDetailsVO queryArticleDetails(String articleId);

    /**
     * @Author ll
     * @Description 编辑文章信息
     * @Date 2020/1/27 21:10
     * @Param [articleId]
     * @return void
     **/
    void editArticleById(String articleId);

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
