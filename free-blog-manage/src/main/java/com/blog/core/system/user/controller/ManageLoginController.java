package com.blog.core.system.user.controller;

import com.blog.core.common.utils.ResponseBo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ManageLoginController
 * @description: 用户登录controller
 * @author: liulin
 * @create: 2019-12-28 14:13
 * @Version: 1.0
 */
@RestController
public class ManageLoginController {

    @GetMapping("/login")
    public ResponseBo login(){
        return ResponseBo.newDataResponse("成功");
    }

}
