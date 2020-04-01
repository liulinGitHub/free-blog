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
     * @Author ll
     * @Description 分页查询评论信息
     * @Date 2020/2/6 17:25
     * @Param []
     * @return java.util.List<com.blog.core.comment.vo.ManageCommentListVO>
     **/
    List<ManageCommentListVO> queryManageCommentByPage();

    /**
     * @Author ll
     * @Description 查询评论信息详情
     * @Date 2020/2/6 17:25
     * @Param [commentBelongId]
     * @return com.blog.core.comment.vo.ManageCommentDetailVO
     **/
    List<ManageCommentDetailVO> queryManageCommentDetails(String commentBelongId);

    /**
     * @Author ll
     * @Description 保存评论信息
     * @Date 2020/2/6 17:24
     * @Param [portalCommentAddDTO]
     * @return void
     **/
    void addManageComment(ManageCommentAddDTO portalCommentAddDTO);

    /**
     * @Author ll
     * @Description 评论点赞
     * @Date 2020/2/6 17:24
     * @Param [commentId]
     * @return void
     **/
    void addManageCommentApproves(String commentId);
}
