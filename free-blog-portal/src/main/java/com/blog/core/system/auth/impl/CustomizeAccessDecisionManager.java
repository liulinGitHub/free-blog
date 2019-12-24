package com.blog.core.system.auth.impl;

import com.blog.core.common.consts.Constants;
import com.blog.core.common.exceptions.NotPermissionException;
import com.blog.core.system.user.entity.domain.SecurityUserDetails;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Objects;

/**
 * @program: CustomizeAccessDecisionManager
 * @description: 操作权限判断器
 * @author: liulin
 * @create: 2019-10-30 17:23
 * @Version: 1.0
 */
@Component
public class CustomizeAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(Objects.isNull(authentication)){
            return;
        }

        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();

        if ("anonymousUser".equals(authentication.getPrincipal())
                || matchers("/images/**", request)
                || matchers("/js/**", request)
                || matchers("/css/**", request)
                || matchers("/fonts/**", request)
                || matchers("/", request)
                || matchers("/favicon.ico", request)
                || matchers("/index.html", request)
                || matchers("/login", request)) {
            return;
        }

        // 如果是超级管理员账号,如果是则直接通过
        SecurityUserDetails securityUserDetails = (SecurityUserDetails)authentication.getPrincipal();
        if(Objects.nonNull(securityUserDetails)){
            if(Constants.ADMIN.equals(securityUserDetails.getUsername())){
                return;
            }
        }
//
//        // 如果允许匿名用户访问就直接通过
//        boolean isAnonymousAccess = configAttributes.stream()
//                .anyMatch(role-> role.equals(ANONYMOUS_ROLE));
//        if (isAnonymousAccess) {
//            return;
//        }
//
        //检查是否拥有权限
        boolean isRightAccess = configAttributes.stream().anyMatch(configAttribute -> {
            String needRole = "ROLE_ADMIN";
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.toLowerCase().trim().equals(grantedAuthority.getAuthority().toLowerCase().trim())) {
                    return true;
                }
            }
            return false;
        });
        if(isRightAccess){
            return;
        }
        //权限不足
        throw new NotPermissionException("没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }
}
