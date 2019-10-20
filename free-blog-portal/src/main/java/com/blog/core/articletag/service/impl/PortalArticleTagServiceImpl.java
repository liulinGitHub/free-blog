package com.blog.core.articletag.service.impl;

import com.blog.core.articletag.dao.PortalArticleTagMapper;
import com.blog.core.articletag.service.PortalArticleTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PortalArticleTagServiceImpl
 * @description: 文章标签中间表
 * @author: liulin
 * @create: 2019-07-27 15:27
 * @Version: 1.0
 */
@Service("portalArticleTagService")
public class PortalArticleTagServiceImpl implements PortalArticleTagService {

    @Resource
    private PortalArticleTagMapper portalArticleTagMapper;
}
