package com.blog.core.comment.service;

import com.blog.core.comment.dto.ManageCommentAddDTO;
import com.blog.core.comment.vo.ManageCommentDetailVO;
import com.blog.core.comment.vo.ManageCommentListVO;
import com.blog.core.comment.vo.ManageCommentVO;

import java.util.List;

/**
 * @program: ManageCommentServiceImpl
 * @description:
 * @author: liulin
 * @create: 2019-12-18 16:41
 * @Version: 1.0
 */
public interface ManageCommentService {

    /**
     * 分页查询评论信息
     * @return
     */
    List<ManageCommentListVO> queryManageCommentByPage();

    /**
     * 根据id查询评论信息
     * @param commentId
     * @return
     */
    ManageCommentDetailVO queryManageCommentById(String commentId);

    /**
     * 根据父id查询评论信息
     * @param parentId
     * @return
     */
    List<ManageCommentVO> queryManageCommentByParentId(String parentId);


    /**
     * 根据文章id查询文章所有评论信息
     * @param articleId
     * @return
     */
    List<ManageCommentVO> queryManageCommentByArticleId(String articleId);

    /**
     * 保存评论信息
     * @param portalCommentAddDTO
     */
    void saveManageComment(ManageCommentAddDTO portalCommentAddDTO);

}
