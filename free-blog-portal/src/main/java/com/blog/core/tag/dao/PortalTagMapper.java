package com.blog.core.tag.dao;

import com.blog.core.tag.entity.qo.PortalTagQueryDTO;
import com.blog.core.tag.entity.vo.PortalTagVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: ManageTagMapper
 * @description: 标签mapper
 * @author: liulin
 * @create: 2019-07-23 17:48
 * @Version: 1.0
 */
@Repository("portalTagMapper")
public interface PortalTagMapper {

    /**
     * 分页查询标签信息
     * @return
     */
    List<PortalTagVO> selectTagByPage(PortalTagQueryDTO portalTagQueryDTO);

    /**
     * 根据标签id查询标签信息
     * @param tagId
     * @return
     */
    List<PortalTagVO> selectTagByArticleId(String tagId);

}
