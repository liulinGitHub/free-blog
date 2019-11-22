package com.blog.core.system.auth.config;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: AnonymousMatcherUtils
 * @description:
 * @author: liulin
 * @create: 2019-11-21 15:18
 * @Version: 1.0
 */
public class AnonymousMatcherUtils {

    private static List<RequestMatcher> anonymousMatchers = new ArrayList<RequestMatcher>();

    public static void configAnonymousMatchers(String... antPatterns) {
        for (String pattern : antPatterns) {
            anonymousMatchers.add(new AntPathRequestMatcher(pattern));
        }
    }

    public static List<RequestMatcher> getAnonymousMatchers() {
        return anonymousMatchers;
    }

    public static boolean isAnonymousAccess(HttpServletRequest request) {
        if(CollectionUtils.isEmpty(getAnonymousMatchers())){
            return false;
        }

        // 符合任意一个匿名访问的路径
        return getAnonymousMatchers().stream()
                .anyMatch(matcher-> matcher.matches(request));
    }

    private AnonymousMatcherUtils(){
        super();
    }
}
