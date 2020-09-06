package com.blog.core.article.service;


import com.blog.core.article.dto.PortalArticleAddDTO;
import com.blog.core.article.dto.PortalArticleApprovalDTO;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.vo.PortalArticleDetailsVO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.vo.PortalArticleListVO;

import java.util.List;

/**
 * @ClassNmae: PortalArticleService
 * @description: 文章信息service
 * @Author: 950103
 * @Date: 2020/4/19 11:26
 **/
public interface PortalArticleService {

    /**
     * 分页查询文章信息
     *
     * @return
     */
    List<PortalArticleListVO> queryPortalArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    PortalArticleDetailsVO queryPortalArticleDetails(Integer articleId);

    /**
     * 提交审核
     *
     * @param portalArticleCheckDTO
     */
    void submitCheckPortalArticle(PortalArticleCheckDTO portalArticleCheckDTO);

    /**
     * 保存文章草稿
     *
     * @param portalArticleAddDTO
     */
    void savePortalArticleDraft(PortalArticleAddDTO portalArticleAddDTO);

    /**
     * 删除文章草稿
     *
     * @param articleId
     */
    void deletePortalArticleDraft(Integer articleId);

    /**
     * 文章点赞
     *
     * @param portalArticleApprovalDTO
     * @return
     */
    void approvesPortalArticle(PortalArticleApprovalDTO portalArticleApprovalDTO);

}
