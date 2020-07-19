package com.blog.core.approva.service.impl;

import com.blog.core.approva.service.PortalApprovalService;
import com.blog.core.common.consts.Constants;
import com.blog.core.common.enums.ApprovalStatusEnum;
import com.blog.core.common.enums.ApprovalTypeEnum;
import com.blog.core.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: PortalApprovalServiceImpl
 * @Description: 点赞Service
 * @date: 2020/7/19 1:54
 * @author: 950103
 * @Version 1.0
 */
@Service
public class PortalApprovalServiceImpl implements PortalApprovalService {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 文章点赞
     *
     * @param approvalType 点赞类型
     * @param subjectId 点赞所属的id
     * @param userId 点赞的用户id
     */
    @Override
    public void approval(ApprovalTypeEnum approvalType, Object subjectId, Object userId) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        //判断点赞用户是否已经点赞
        Boolean isApproval = redisUtil.sIsMember(approvalKey, userId);
        if (isApproval) {
            //如果存在，说明重复调用，则是取消点赞
            redisUtil.delete(approvalKey);
        } else {
            //如果存在，则点赞成功
            redisUtil.sAdd(approvalKey, userId + "");
        }
    }

    @Override
    public void approval(ApprovalTypeEnum approvalType, Object subjectId, Object userId, Object userApprovalVO) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        boolean isApproval = redisUtil.hExists(approvalKey, userId);
        if (isApproval) {
            //如果存在，说明重复调用，则是取消点赞
            redisUtil.hDelete(approvalKey, userId);
        } else {
            //如果存在，则点赞成功
            redisUtil.hPut(approvalKey, userId, userApprovalVO);
        }
    }

    @Override
    public Set<Object> obtainApprovalUserId(ApprovalTypeEnum approvalType, Object subjectId) {
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        Set<Object> approvalUserIdSet = redisUtil.setMembers(approvalKey);
        return approvalUserIdSet;
    }

    @Override
    public void approval(ApprovalTypeEnum approvalType, Object subjectId, Object subject, Object postId, Object postUser) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        boolean isApproval = redisUtil.hExists(approvalKey, postId);
        if (isApproval) {
            //如果存在，说明重复调用，则是取消点赞
            redisUtil.hDelete(approvalKey, postId);
            //计入统计数据
            this.increment(approvalType, subject, ApprovalStatusEnum.UN_APPROVAL);
        } else {
            //如果存在，则点赞成功
            redisUtil.hPut(approvalKey, postId, postUser);
            //计入统计数据
            this.increment(approvalType, subject, ApprovalStatusEnum.APPROVAL);
        }
    }

    @Override
    public Long obtainApprovalCount(ApprovalTypeEnum approvalType, Object subjectId) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        // return redisUtil.sSize(approvalKey);
        return redisUtil.hSize(approvalKey);
    }

    @Override
    public Set<Object> obtainApprovalSubjectSet(ApprovalTypeEnum approvalType, Object subjectId) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        Object o = redisUtil.sSize(approvalKey);
        return null;
    }

    @Override
    public void increment(ApprovalTypeEnum approvalType, Object subject, ApprovalStatusEnum approvalStatus) {
        //获取点赞统计key
        String reportKey = Constants.getReportKey(approvalType);
        if (ApprovalStatusEnum.APPROVAL.equals(approvalStatus)) {
            // 判断key是否存在
            boolean isReportKey = redisUtil.hasKey(reportKey);
            if (isReportKey) {
                redisUtil.zIncrementScore(reportKey, subject, approvalStatus.getValue());
            } else {
                redisUtil.zAdd(reportKey, subject, approvalStatus.getValue());
            }
        } else if (ApprovalStatusEnum.UN_APPROVAL.equals(approvalStatus)) {
            redisUtil.zIncrementScore(reportKey, subject, approvalStatus.getValue());
        }
    }

    @Override
    public List<Object> getPostUserList(ApprovalTypeEnum approvalType, Object subjectId) {
        //生成点赞key
        String approvalKey = Constants.getApprovalKey(approvalType, subjectId);
        List<Object> list = redisUtil.hValues(approvalKey);
        return list;
    }

    @Override
    public Set<Object> obtainSubjectTopN(ApprovalTypeEnum approvalType, Long top) {
        //获取点赞统计key
        String reportKey = Constants.getReportKey(approvalType);
        Set<Object> set = redisUtil.zReverseRange(reportKey, 0, top);
        return set;
    }
}
