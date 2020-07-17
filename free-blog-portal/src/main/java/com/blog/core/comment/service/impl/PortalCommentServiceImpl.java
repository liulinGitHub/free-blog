package com.blog.core.comment.service.impl;

import com.blog.core.comment.dao.PortalCommentMapper;
import com.blog.core.comment.dto.PortalCommentAddDTO;
import com.blog.core.comment.entity.PortalComment;
import com.blog.core.comment.vo.PortalCommentVO;
import com.blog.core.comment.vo.PortalCommentTree;
import com.blog.core.comment.service.PortalCommentService;
import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.IsEnableEnum;
import com.blog.core.common.enums.IsParentEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName: PortalCommentServiceImpl
 * @Description: 评论相关信息Service实现类
 * @Author: 950103
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
@Slf4j
@Service("portalCommentService")
public class PortalCommentServiceImpl implements PortalCommentService {

    @Autowired
    private PortalCommentMapper portalCommentMapper;

    @Override
    public List<PortalCommentTree> queryPortalCommentTree(String id) {
        List<PortalCommentTree> portalCommentTreeList = this.portalCommentMapper.selectPortalCommentTree(id);
        if (CollectionUtils.isEmpty(portalCommentTreeList)) {
            return new ArrayList<>();
        }
        List<PortalCommentTree> commentTreeList = portalCommentTreeList.stream()
                .filter(portalCommentTree -> StringUtils.isBlank(portalCommentTree.getParentId()))
                .collect(Collectors.toList());
        for (PortalCommentTree commentTree : commentTreeList) {
            List<PortalCommentTree> childrenList = portalCommentTreeList.stream().filter(portalCommentTree ->
                    StringUtils.isNotBlank(portalCommentTree.getParentId())
                            && portalCommentTree.getParentId().equals(commentTree.getCommentId())
            ).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(childrenList)) {
                for (PortalCommentTree portalCommentTree : childrenList) {
                    if (commentTree.getChildren() == null) {
                        commentTree.setChildren(new ArrayList<>());
                    }
                    commentTree.getChildren().add(portalCommentTree);
                }
            }
        }
        return commentTreeList;
    }

    @Override
    public List<PortalCommentVO> queryCommentByParentId(String parentId) {
        List<PortalCommentVO> portalCommentVOList = this.portalCommentMapper.queryCommentByParentId(parentId);
        return portalCommentVOList;
    }

    @Override
    @Transactional
    public void     savePortalComment(PortalCommentAddDTO portalCommentAddDTO) {
        PortalComment portalComment = MapperUtils.mapperBean(portalCommentAddDTO, PortalComment.class);
        portalComment.setCommentId(UUIDUtil.randomUUID32());
        portalComment.setCommentUserId(RequestHolder.get()+"");
        portalComment.setCommentTime(new Date());
        portalComment.setIsEnable(IsEnableEnum.Enable_NO.getValue());
        portalComment.setArticleId(portalCommentAddDTO.getArticleId());
        if(Objects.nonNull(portalComment.getParentId())){
            portalComment.setParentId(portalComment.getParentId());
            portalComment.setIsParent(IsParentEnum.PARENT_NO.getValue());
        }else {
            portalComment.setParentId("0");
            portalComment.setIsParent(IsParentEnum.PARENT_YES.getValue());
        }
        int result = this.portalCommentMapper.insertPortalComment(portalComment);
        if (result < 1) {
            log.error("评论失败!【{}】", "commentUserId");
            throw new BlogRuntimeException("评论失败！");
        }
        //增加文章评论数 后置事件
        //this.Service.updateComments(Id);
        //publisher.publish(new Event(Id));
    }
}
