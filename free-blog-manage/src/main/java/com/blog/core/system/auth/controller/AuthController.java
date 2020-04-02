package com.blog.core.system.auth.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.IPUtils;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.service.AuthService;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.auth.vo.ManageUserInfoVO;
import com.blog.core.system.onlineuser.service.ManageOnlineUserService;
import com.blog.core.system.user.dto.ManageUserLoginInfoEditDTO;
import com.blog.core.system.user.service.ManageUserService;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
    private ManageUserService manageUserService;

    @Autowired
    private ManageOnlineUserService manageOnlineUserService;

    @Autowired
    private RedisUtil redisUtil;


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
    public ResponseBo queryUserInfo(HttpServletRequest request){
        SecurityUser securityUser = SecurityUtils.getUser();
        //获取用户信息
        ManageUserInfoVO manageUserInfoVO = this.authService.queryUserInfo();
        //修改用户登录相关信息
        ManageUserLoginInfoEditDTO manageUserLoginInfoEditDTO = ManageUserLoginInfoEditDTO.builder()
                .userId(securityUser.getUserId())
                .lastLoginIp(IPUtils.getIpAddr(request))
                .lastLoginTime(new Date())
                .updateId(securityUser.getUserId())
                .updateTime(new Date())
                .build();
        this.manageUserService.editManageUserLoginInfo(manageUserLoginInfoEditDTO);
        //保存在线用户
        this.manageOnlineUserService.addOnlineUser(securityUser.getUserId());
        return ResponseBo.newDataResponse(manageUserInfoVO);
    }

    @ApiOperation("退出登录")
    @DeleteMapping(value = "/logout")
    public ResponseBo logout(HttpServletRequest request){
        return ResponseBo.ok();
    }
}
