package com.blog.core.system.role.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.vo.ManageRoleInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageRoleServiceImplTest {

    @Autowired
    private ManageRoleService manageRoleService;

    @Test
    public void queryRoleMenuInfoByUserId() {
    }

    @Test
    public void queryRoleInfoByUserId() {
        String userId = "8e20ed1dc3084825800957a89d2061d2";
        Collection<GrantedAuthority> grantedAuthorities = manageRoleService.queryRoleInfoByUserId(userId);
        System.out.println(JSONObject.toJSONString(grantedAuthorities));
    }
}
