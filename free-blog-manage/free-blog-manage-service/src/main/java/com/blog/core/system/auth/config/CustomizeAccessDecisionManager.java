package com.blog.core.system.auth.config;//package com.blog.core.system.auth.config;
//
//import com.blog.core.system.auth.entity.SecurityUserDetails;
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
///**
// * @program: CustomizeAccessDecisionManager
// * @description: 操作权限判断器
// * @author: 950103
// * @create: 2019-11-25 16:14
// * @Version: 1.0
// */
//@Component
//public class CustomizeAccessDecisionManager implements AccessDecisionManager {
//
//    @Override
//    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        SecurityUserDetails securityUserDetails = (SecurityUserDetails)authentication.getPrincipal();
//
//        return;
//    }
//
//    @Override
//    public boolean supports(ConfigAttribute attribute) {
//        return false;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//}
