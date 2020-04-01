package com.blog.core.system.auth.controller;

import cn.hutool.core.util.IdUtil;
import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.auth.entity.AuthManageUser;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassNmae: AuthController
 * @description: 权限controller
 * @Author: liulin
 * @Date: 2020/3/3 15:49
 **/
@Slf4j
@RestController
@RequestMapping("/auth")
@Api(tags = "系统：系统授权接口")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtil redisUtil;

    @LogManage("登录授权")
    @ApiOperation("登录授权")
    @PostMapping("/login")
    public ResponseBo login(@RequestBody AuthManageUser authManageUser){
        return ResponseBo.newDataResponse(authService.login(authManageUser));
    }

    @LogManage("获取验证码")
    @ApiOperation("获取验证码")
    @GetMapping(value = "/code")
    public ResponseBo getCode(){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        // 保存
        redisUtil.set("CAPTCHA_CODE", result, 2, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
        }};
        return ResponseBo.newDataResponse(imgResult);
    }

    @ApiOperation("获取用户信息")
    @GetMapping(value = "/info")
    public ResponseBo queryUserInfo(){
//        this.authService.queryUserInfo();
//
//        SecurityUser user = SecurityUtils.getUser();
//        Set<String> permissions = new HashSet<>();
//        permissions.add("user:list");
//        Collection<GrantedAuthority> roles = permissions.stream().map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        SecurityUser securityUser = new SecurityUser(
//                "1001",
//                "测试用户",
//                "****",
//                "男",
//                "测试昵称",
//                "xxx",
//                "123",
//                "123",
//                roles);
        return ResponseBo.newDataResponse(this.authService.queryUserInfo());
    }

    @ApiOperation("退出登录")
    @DeleteMapping(value = "/logout")
    public ResponseBo logout(HttpServletRequest request){
        return ResponseBo.ok();
    }
}
