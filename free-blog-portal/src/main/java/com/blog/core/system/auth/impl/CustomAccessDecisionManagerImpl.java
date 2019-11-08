package com.blog.core.system.auth.impl;

import com.blog.core.common.consts.Constants;
import com.blog.core.common.exceptions.NotPermissionException;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Objects;

/**
 * @program: CustomAccessDecisionManagerImpl
 * @description: 操作权限判断器
 * @author: liulin
 * @create: 2019-10-30 17:23
 * @Version: 1.0
 */
public class CustomAccessDecisionManagerImpl implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(Objects.isNull(authentication)){
            return;
        }

        // 如果是超级管理员账号,如果是则直接通过
        Object obj = authentication.getPrincipal();
        if(obj instanceof UserDetails){
            UserDetails details = (UserDetails) obj;
            //如果登录名为admin，直接通过
            if(Constants.ADMIN.equals(details.getUsername())){
                return;
            }
        }

        //检查是否拥有权限
        boolean isRightAccess = configAttributes.stream().anyMatch(configAttribute -> {
            String needRole = configAttribute.getAttribute();
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
}
