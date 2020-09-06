package com.blog.core.tag.dao;

import com.blog.core.tag.dto.PortalTagQueryDTO;
import com.blog.core.tag.vo.PortalTagVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: ManageTagMapper
 * @description: 标签mapper
 * @author: 950103
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
    List<PortalTagVO> selectTagByArticleId(Integer tagId);

}
