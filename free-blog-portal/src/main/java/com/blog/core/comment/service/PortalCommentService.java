package com.blog.core.comment.service;

import com.blog.core.comment.entity.dto.PortalCommentAddDTO;
import com.blog.core.comment.entity.vo.PortalCommentVO;
import com.blog.core.comment.entity.vo.PortalCommentTree;

import java.util.List;

/**
 * @ClassName: PortalCommentService
 * @Description: 评论相关信息Service
 * @Author: 950103
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
    PortalCommentVO queryCommentById(String commentId);

    /**
     * 根据父id查询评论信息
     * @param parentId
     * @return
     */
    List<PortalCommentVO> queryCommentByParentId(String parentId);


    /**
     * 根据文章id查询文章所有评论信息
     * @param articleId
     * @return
     */
    List<PortalCommentVO> queryCommentByArticleId(String articleId);

    /**
     * 保存评论信息
     * @param portalCommentAddDTO
     */
    void saveComment(PortalCommentAddDTO portalCommentAddDTO);

}
