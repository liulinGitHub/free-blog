package com.blog.core.system.auth.impl;

import com.blog.core.system.menu.entity.vo.PortalMenuVO;
import com.blog.core.system.menu.service.PortalMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

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
    private PortalMenuService portalMenuService;

    private Set<String> perimssionUrls = new HashSet<>();

    /**
     * 加载权限表中所有权限
     */
    @PostConstruct
    public void loadResourceDefine(){
        List<PortalMenuVO> portalRoleVOList = this.portalMenuService.queryMenuList();
        perimssionUrls = portalRoleVOList.stream().map(PortalMenuVO::getMenuUrl).collect(Collectors.toSet());
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        String url = request.getRequestURI().trim();

        if(StringUtils.isBlank(url)) {
            return null;
        }
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        Collection<ConfigAttribute> list = new ArrayList<>();
        for (String perimssionUrl : perimssionUrls){
            if (StringUtils.isNotBlank(perimssionUrl) && antPathMatcher.match(perimssionUrl, url)) {
                ConfigAttribute configAttribute = new SecurityConfig(url);
                list.add(configAttribute);
            }
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
