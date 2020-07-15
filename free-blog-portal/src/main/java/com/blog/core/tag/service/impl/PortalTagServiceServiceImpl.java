package com.blog.core.tag.service.impl;

import com.blog.core.tag.dao.PortalTagMapper;
import com.blog.core.tag.entity.qo.PortalTagQueryDTO;
import com.blog.core.tag.entity.vo.PortalTagVO;
import com.blog.core.tag.service.PortalTagService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PortalTagServiceServiceImpl
 * @description: 标签service实现类
 * @author: 950103
 * @create: 2019-07-23 17:39
 * @Version: 1.0
 */
@Service("portalTagService")
public class PortalTagServiceServiceImpl implements PortalTagService {

    @Resource
    private PortalTagMapper portalTagMapper;

    @Override
    public List<PortalTagVO> queryTagByPage(PortalTagQueryDTO portalTagQueryDTO){
        List<PortalTagVO> porTagVOList = this.portalTagMapper.selectTagByPage(portalTagQueryDTO);
        return porTagVOList;
    }

    @Override
    public List<PortalTagVO> queryTagByArticleId(String articleId) {
        List<PortalTagVO> portalTagVOList = this.portalTagMapper.selectTagByArticleId(articleId);
        return portalTagVOList;
    }


}
