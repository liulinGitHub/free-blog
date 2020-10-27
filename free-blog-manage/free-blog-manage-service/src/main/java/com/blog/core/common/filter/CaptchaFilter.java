//package com.blog.core.common.filter;
//
//import com.blog.core.common.exceptions.CaptchaException;
//import com.blog.core.common.redis.RedisUtil;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.bind.ServletRequestBindingException;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
///**
// * @Description: 登录验证码校验过滤器
// * OncePerRequestFilter 该过滤器之后执行一次
// * @author: 950103
// * @create_time: 2020/9/6 18:17
// * @version 1.0
// */
//@Setter
//@Getter
//@Slf4j
//public class CaptchaFilter extends OncePerRequestFilter implements InitializingBean {
//
//    private RedisUtil redisUtil;
//
//    private AuthenticationFailureHandler failureHandler;
//
//    /**
//     * 验证码请求拦截路径
//     */
//    private Set<String> interceptUrlSet = new HashSet<>();
//
//    private AntPathMatcher antPathMatcher = new AntPathMatcher();
//
//    @Override
//    public void afterPropertiesSet() throws ServletException {
//        super.afterPropertiesSet();
//        //登录请求验证
//        interceptUrlSet.add("/oauth/token");
//
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        for (String url : interceptUrlSet) {
//            if (antPathMatcher.match(url, request.getRequestURI())) {
//                try {
//                    validateCaptcha(request);
//                } catch (CaptchaException captchaException) {
//                    log.error("验证码异常", captchaException);
//                    throw new CaptchaException(captchaException.getMessage());
//                }
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private void validateCaptcha(HttpServletRequest request) throws ServletRequestBindingException {
//        String requestCaptcha = ServletRequestUtils.getStringParameter(request, "captcha");
//        if (StringUtils.isBlank(requestCaptcha)) {
//            throw new CaptchaException("验证码的值不能为空！");
//        }
//        String redisCaptcha = (String) redisUtil.get(ServletRequestUtils.getStringParameter(request, "uuid"));
//        if (StringUtils.isBlank(redisCaptcha)) {
//            // TODO 先判断redis 有不有 没有在判断数据库有没有，
//            // TODO 数据库没有代表验证码生成失败，
//            // TODO 数据库有redis没有代表验证码已经过期
//            throw new CaptchaException("输入的验证码已过期！");
//        }
//        if (! redisCaptcha.equals(redisCaptcha)) {
//            throw new CaptchaException("输入的验证码不匹配！");
//        }
//    }
//}
