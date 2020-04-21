package com.blog.core.comment.service;

import com.blog.core.comment.entity.dto.PortalArticleCommentAddDTO;
import com.blog.core.comment.entity.vo.PortalArticleCommentVO;
import com.blog.core.comment.entity.vo.PortalCommentTree;

import java.util.List;

/**
 * @ClassName: PortalCommentService
 * @Description: 评论相关信息Service
 * @Author: liulin
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */

public interface PortalCommentService {

    List<PortalCommentTree> queryPortalCommentTree(String articleId);

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
