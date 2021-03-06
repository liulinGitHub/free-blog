package com.blog.core.system.auth.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.IPUtils;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.auth.vo.UserInfoVO;
import com.blog.core.system.onlineuser.service.OnlineUserService;
import com.blog.core.system.user.dto.UserLoginInfoEditDTO;
import com.blog.core.system.user.service.UserService;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description: 系统登录Controller
 * @author: 950103
 * @create_time: 2020/3/3 15:49
 * @version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/auth")
@Api(tags = "系统登录Controller")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService UserService;

    @Autowired
    private OnlineUserService onlineUserService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/code")
    public ResponseBo getCode() {
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

    @LogManage("获取用户信息")
    @ApiOperation("获取用户信息")
    @GetMapping(value = "/info")
    public ResponseBo queryUserInfo(HttpServletRequest request){
        SecurityUser currentUser = SecurityUtils.getUser();
        //获取用户信息
        UserInfoVO userInfoVO = this.authService.queryUserInfo();
        //修改用户登录相关信息
        UserLoginInfoEditDTO userLoginInfoEditDTO = UserLoginInfoEditDTO.builder()
                .userId(currentUser.getUserId())
                .lastLoginIp(IPUtils.getIpAddr(request))
                .lastLoginTime(new Date())
                .updateId(currentUser.getUserId())
                .updateTime(new Date())
                .build();
        this.UserService.editUserLoginInfo(userLoginInfoEditDTO);
        //保存在线用户
        this.onlineUserService.addOnlineUser(currentUser);
        return ResponseBo.newDataResponse(userInfoVO);
    }

    @LogManage("退出登录")
    @ApiOperation("退出登录")
    @DeleteMapping(value = "/logout")
    public ResponseBo logout(HttpServletRequest request){
        return ResponseBo.ok();
    }
}
