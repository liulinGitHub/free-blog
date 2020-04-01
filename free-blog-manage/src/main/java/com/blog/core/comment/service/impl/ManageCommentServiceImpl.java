package com.blog.core.comment.service.impl;

import com.blog.core.comment.dao.ManageCommentMapper;
import com.blog.core.comment.dto.ManageCommentAddDTO;
import com.blog.core.comment.entity.ManageComment;
import com.blog.core.comment.vo.ManageCommentDetailVO;
import com.blog.core.comment.vo.ManageCommentListVO;
import com.blog.core.comment.service.ManageCommentService;
import com.blog.core.common.enums.IsEnableEnum;
import com.blog.core.common.enums.IsParentEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.PrimarykeyUtil;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: ManageCommentServiceImpl
 * @description:
 * @author: liulin
 * @create: 2019-12-18 16:41
 * @Version: 1.0
 */
@Service
public class ManageCommentServiceImpl implements ManageCommentService {

    @Autowired
    private ManageCommentMapper manageCommentMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Override
    public List<ManageCommentListVO> queryManageCommentByPage() {
        List<ManageCommentListVO> manageCommentVOList = this.manageCommentMapper.selectManageCommentByPage();
        if(CollectionUtils.isNotEmpty(manageCommentVOList)){
            Map<String, List<ManageCommentListVO>> map = manageCommentVOList.stream()
                    .filter(manageCommentDetailVO ->
                            IsParentEnum.PARENT_YES.getValue().equals(manageCommentDetailVO.getIsParent()))
                    .collect(Collectors.groupingBy(ManageCommentListVO::getCommentParentId));
            if(Objects.isNull(map)){
                return manageCommentVOList;
            }
            manageCommentVOList = manageCommentVOList.stream()
                    .filter(manageComment ->
                            Objects.isNull(manageComment.getCommentParentId())
                                    && map.containsKey(manageComment.getCommentId()))
                    .map(manageComment -> this.getChildCommentTree(map, manageComment))
                    .sorted()
                    .collect(Collectors.toList());
            return manageCommentVOList;
        }
        return manageCommentVOList;
    }

    private ManageCommentListVO getChildCommentTree(Map<String, List<ManageCommentListVO>> map
            ,ManageCommentListVO manageCommentListVO){
        ManageCommentListVO commentListVO = MapperUtils.mapperBean(manageCommentListVO, ManageCommentListVO.class);
        List<ManageCommentListVO> manageCommentListVOS = map.get(manageCommentListVO.getCommentId());
        if(CollectionUtils.isEmpty(manageCommentListVOS)){
            return commentListVO;
        }
        if(Objects.isNull(commentListVO.getManageCommentList())){
            commentListVO.setManageCommentList(new ArrayList<>());
        }
        for(ManageCommentListVO _manageComment : manageCommentListVOS){
            commentListVO.getManageCommentList().add(getChildCommentTree(map, _manageComment));
        }
        return commentListVO;
    }

    @Override
    public List<ManageCommentDetailVO> queryManageCommentDetails(String commentBelongId) {
        List<ManageCommentDetailVO> manageCommentDetailVOList = this.manageCommentMapper.selectManageCommentById(commentBelongId);
        return manageCommentDetailVOList;
    }

    @Transactional
    @Override
    public void addManageComment(ManageCommentAddDTO manageCommentAddDTO) {
        SecurityUser user = SecurityUtils.getUser();
        ManageComment manageComment = MapperUtils.mapperBean(manageCommentAddDTO, ManageComment.class);
        manageComment.setCommentId(primarykeyUtil.getPimaryKey());
        manageComment.setCommentTime(new Date());
        manageComment.setCreateTime(new Date());
        manageComment.setCreateId(user.getUserId());
        manageComment.setIsEnable(IsEnableEnum.Enable_YES);
        this.manageCommentMapper.insertManageComment(manageComment);
    }

    @Transactional
    @Override
    public void addManageCommentApproves(String commentId) {

    }
}
