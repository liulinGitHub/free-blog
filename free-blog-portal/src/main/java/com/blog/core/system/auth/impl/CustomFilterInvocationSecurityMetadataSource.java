package com.blog.core.system.auth.impl;

import com.blog.core.system.auth.config.AnonymousMatcherUtils;
import com.blog.core.system.role.entity.vo.PortalRoleVO;
import com.blog.core.system.role.service.PortalRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @program: CustomFilterInvocationSecurityMetadataSource
 * @description: 操作权限生成器，针对于用户操作(例如：url请求),定义操作所需要的权限
 * @author: liulin
 * @create: 2019-10-30 17:44
 * @Version: 1.0
 */
@Service
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private PortalRoleService portalRoleService;

    public static final PortalRoleVO ANONYMOUS_ROLE =
            new PortalRoleVO("-200", "匿名角色", "ANONYMOUS_ROLE_CODE");

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        String requestUrl = request.getRequestURI().trim();

        if(StringUtils.isBlank(requestUrl)) {
            return null;
        }
        // AntPathMatcher antPathMatcher = new AntPathMatcher();

        Collection<ConfigAttribute> list = new ArrayList<>();
        if(AnonymousMatcherUtils.isAnonymousAccess(request)){
            list.add(ANONYMOUS_ROLE);
        }

        List<PortalRoleVO> portalRoleVOList = portalRoleService.queryRoleByUrl(requestUrl);
        if(CollectionUtils.isNotEmpty(portalRoleVOList)){
            CollectionUtils.addAll(list, portalRoleVOList.iterator());
        }
        return list;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
