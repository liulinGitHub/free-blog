package com.blog.core.article.service;

import com.blog.core.common.enums.ApprovalStatusEnum;
import com.blog.core.common.enums.ApprovalTypeEnum;
import com.blog.core.system.user.vo.PortalUserApprovalVO;

import java.util.List;
import java.util.Set;

/**
 * @ClassNmae: PortalArticleApprovalService
 * @description: 文章点赞
 * @Author: liulin
 * @Date: 2020/3/25 11:08
 **/
public interface PortalArticleApprovalService {

    void approval(ApprovalTypeEnum approvalType, Object subjectId,  Object userId);

    void approval(ApprovalTypeEnum approvalType, Object subjectId, Object userId, Object userApprovalVO);

    Set<Object> obtainApprovalUserId(ApprovalTypeEnum approvalType, Object subjectId);

    /**
     * 点赞/取消赞
     * @param approvalType 点赞业务类型
     * @param subjectId    被点赞主题id
     * @param subject      被点赞主题详细信息
     * @param postId       点赞对象id
     * @param postUser     点赞对象详细信息
     */
    void approval(ApprovalTypeEnum approvalType, Object subjectId,  Object subject, Object postId, Object postUser);

    /**
     * 获取点赞数量
     *
     * @param approvalType 点赞业务类型
     * @param subjectId    被点赞主题id
     * @return
     */
    Long obtainApprovalCount(ApprovalTypeEnum approvalType, Object subjectId);


    /**
     * 获取点赞主题详情
     *
     * @param approvalType 点赞业务类型
     * @param subjectId    被点赞主题id
     * @return
     */
    Set<Object> obtainApprovalSubjectSet(ApprovalTypeEnum approvalType, Object subjectId);

    /**
     * 被点赞主体点赞数量 +1 或 -1
     *
     * @param approvalType   点赞业务类型
     * @param subject        被点赞主题
     * @param approvalStatus 点赞状态
     */
    void increment(ApprovalTypeEnum approvalType, Object subject, ApprovalStatusEnum approvalStatus);

    /**
     * 获取点赞主体详情
     * @param approvalType  点赞业务类型
     * @param subjectId     被点赞主体ID
     * @return
     */
    List<Object> getPostUserList(ApprovalTypeEnum approvalType, Object subjectId);

    /**
     * TopN查询
     * 获取approvalType类型下的点赞数最高前 top排名
     * @param approvalType
     * @param top
     * @return
     */
    Set<Object> obtainSubjectTopN(ApprovalTypeEnum approvalType, Long top);
}
