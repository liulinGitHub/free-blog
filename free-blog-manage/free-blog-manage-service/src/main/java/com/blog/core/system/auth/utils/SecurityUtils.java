package com.blog.core.system.auth.utils;

import com.blog.core.system.auth.entity.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.misc.BASE64Encoder;

import java.util.Objects;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/2/2 13:04
 * @version: 1.0
 **/
public class SecurityUtils {

    public static SecurityUser getUser() {
        Authentication authentication = getAuthentication();
        if(Objects.isNull(authentication)) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUser) {
            return (SecurityUser) principal;
        }
        return null;
    }

    /**
     * 获取当前用户名
     *
     * @return
     */
    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if(Objects.nonNull(authentication)) {
            Object principal = authentication.getPrincipal();
            if(Objects.nonNull(principal) && principal instanceof SecurityUser) {
                username = ((SecurityUser) principal).getUsername();
            }
        }
        return username;
    }

    /**
     * 获取当前用户的用户id
     *
     * @return userId
     */
    public static Integer getUserId() {
        Integer userId = null;
        Authentication authentication = getAuthentication();
        if(Objects.nonNull(authentication)) {
            Object principal = authentication.getPrincipal();
            if(Objects.nonNull(principal) && principal instanceof SecurityUser) {
                userId = ((SecurityUser) principal).getUserId();
            }
        }
        return userId;
    }

    /**
     * 获取Authentication
     *
     * @return
     */
    public static Authentication getAuthentication() {
        SecurityContext sc = SecurityContextHolder.getContext();
        if(Objects.isNull(sc)) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    public static void main(String[] args) {
        String str = "freeBlog";
        String code = new BASE64Encoder().encode(str.getBytes());
        System.out.println(code);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode("123456");
//        System.out.println(encode);
    }
}
