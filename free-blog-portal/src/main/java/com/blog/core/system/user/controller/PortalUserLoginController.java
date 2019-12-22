package com.blog.core.system.user.controller;

import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.RedisUtil;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.entity.domain.SecurityUserDetails;
import com.blog.core.system.user.entity.dto.PortalUserLoginDTO;
import com.blog.core.system.user.entity.vo.PortalUserLoginVO;
import com.blog.core.system.user.service.PortalUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.tio.http.common.HttpRequest;
import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassNmae: UserLoginController
 * @description: 用户登陆Controller
 * @Author: liulin
 * @Date: 2019/4/11 23:19
 **/

@Api(value = "用户登陆Controller",tags = "用户登陆")
@RestController
public class PortalUserLoginController {

    @Autowired
    private PortalUserService portalUserService;

    @Resource
    private RedisUtil redisUtil;

    @LogPortal("用户登陆")
    @ApiOperation(value="用户登陆", notes="")
    @RequestMapping("/login")
    public ResponseBo login(@AuthenticationPrincipal SecurityUserDetails portalUserLoginDTO){
        //判断用户信息
//        PortalUserLoginVO portalUserLoginVO = this.portalUserService.checkLogin(portalUserLoginDTO);
//        //获取token
//        //String token = TokenUtils.getToken(portalUserLoginVO);
//        String token = "123456";
//        //token存入redis
//        //redisUtil.set(token,portalUserLoginVO.getUserId());
//        portalUserLoginVO.setToken(token);
        return ResponseBo.newDataResponse(portalUserLoginDTO);
    }

    @LogPortal("获取用户相关信息")
    @ApiOperation(value="获取用户相关信息", notes="")
    @GetMapping("/user/info")
    public ResponseBo queryUserInfo(@RequestParam String userId){
        return ResponseBo.newDataResponse(this.portalUserService.queryUserInfo(userId));
    }

    @LogPortal("退出登陆")
    @ApiOperation(value="退出登陆", notes="")
    @GetMapping("logout")
    public ResponseBo logout(HttpRequest httpRequest){
        String token = httpRequest.getHeader("token");
        redisUtil.delete(token);
        return ResponseBo.ok("退出登陆!");
    }
}
