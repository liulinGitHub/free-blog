package com.blog.core.system.auth.impl;

import com.blog.core.system.role.entity.vo.PortalRoleVO;
import com.blog.core.system.role.service.PortalRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: CustomFilterInvocationSecurityMetadataSource
 * @description: 操作权限生成器，针对于用户操作(例如：url请求),定义操作所需要的权限
 * @author: liulin
 * @create: 2019-10-30 17:44
 * @Version: 1.0
 */
//@Component("customFilterInvocationSecurityMetadataSource")
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private PortalRoleService portalRoleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();

        String url = ((FilterInvocation) object).getRequestUrl().trim();

        if(StringUtils.isBlank(url)) {
            return null;
        }
        Collection<ConfigAttribute> tmpList = new ArrayList<>();
        List<PortalRoleVO> portalRoleVOList = this.portalRoleService.queryRoleByUrl(url);
        if(CollectionUtils.isNotEmpty(portalRoleVOList)){
            CollectionUtils.addAll(tmpList, portalRoleVOList.iterator());
        }
        return tmpList;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Collection<ConfigAttribute> tmpList = new ArrayList<>();
        List<PortalRoleVO> portalRoleVOList = this.portalRoleService.queryPortalRole();
        if(CollectionUtils.isNotEmpty(portalRoleVOList)){
            CollectionUtils.addAll(tmpList, portalRoleVOList.iterator());
        }
        return tmpList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
