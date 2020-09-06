package com.blog.core.tag.service;

import com.blog.core.tag.dto.PortalTagQueryDTO;
import com.blog.core.tag.vo.PortalTagVO;

import java.util.List;

/**
 * @ClassName: PortalTagService
 * @description: 标签Service
 * @author: 950103
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
     *
     * @param articleId
     * @return
     */
    List<PortalTagVO> queryTagByArticleId(Integer articleId);

}
