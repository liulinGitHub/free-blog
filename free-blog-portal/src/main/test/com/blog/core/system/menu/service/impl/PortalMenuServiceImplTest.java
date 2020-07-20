package com.blog.core.system.menu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.system.menu.service.PortalMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PortalMenuServiceImplTest {

    @Autowired
    private PortalMenuService portalMenuService;

    @Test
    public void queryMenuList() {
    }

    @Test
    public void queryMenuByUserId() {
    }

    @Test
    public void queryUserMenu() {
        List<PortalMenuTree> portalMenuTrees = this.portalMenuService.queryUserMenu();
        System.out.println(JSONObject.toJSONString(portalMenuTrees));
    }
}
