package com.blog.core.comment.service;


import com.blog.core.comment.dto.PortalApprovalCommentDTO;
import com.blog.core.comment.dto.PortalCommentAddDTO;
import com.blog.core.comment.vo.PortalCommentTree;
import java.util.List;

/**
 * @ClassName: PortalCommentService
 * @Description: 评论相关信息Service
 * @Author: 950103
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
public interface PortalCommentService {

    /**
     * 查询评论信息
     *
     * @param articleId
     * @return
     */
    List<PortalCommentTree> queryPortalCommentTree(Integer articleId);

    /**
     * 保存评论信息
     *
     * @param portalCommentAddDTO
     */
    void savePortalComment(PortalCommentAddDTO portalCommentAddDTO);

    /**
     * 评论点赞
     * 取消赞
     *
     * @param portalApprovalCommentDTO
     */
    void approvalPortalComment(PortalApprovalCommentDTO portalApprovalCommentDTO);
}
