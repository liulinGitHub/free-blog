package com.blog.core.tag.service;

import com.blog.core.tag.entity.qo.PortalTagQueryDTO;
import com.blog.core.tag.entity.vo.PortalTagVO;

import java.util.List;

/**
 * @program: ManageTagService
 * @description: 标签Service
 * @author: liulin
 * @create: 2019-07-23 17:39
 * @Version: 1.0
 */
public interface PortalTagService {

    /**
     * 分页查询标签信息
     * @return
     */
    List<PortalTagVO> queryTagByPage(PortalTagQueryDTO portalTagQueryDTO);

    /**
     * 根据文章id查询标签信息
     * @param articleId
     * @return
     */
    List<PortalTagVO> queryTagByArticleId(String articleId);

}
