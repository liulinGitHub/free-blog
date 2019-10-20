package com.blog.core.comment.service;

import com.blog.core.comment.entity.dto.PortalArticleCommentAddDTO;
import com.blog.core.comment.entity.vo.PortalArticleCommentVO;

import java.util.List;

public interface PortalCommentService {

    List<PortalArticleCommentVO> queryArticleCommentByPage();

    /**
     * 根据id查询评论信息
     * @param commentId
     * @return
     */
    PortalArticleCommentVO queryCommentById(String commentId);

    /**
     * 根据父id查询评论信息
     * @param parentId
     * @return
     */
    List<PortalArticleCommentVO> queryCommentByParentId(String parentId);


    /**
     * 根据文章id查询文章所有评论信息
     * @param articleId
     * @return
     */
    List<PortalArticleCommentVO> queryCommentByArticleId(String articleId);

    /**
     * 保存评论信息
     * @param portalCommentAddDTO
     */
    void saveArticleComment(PortalArticleCommentAddDTO portalCommentAddDTO);

}
