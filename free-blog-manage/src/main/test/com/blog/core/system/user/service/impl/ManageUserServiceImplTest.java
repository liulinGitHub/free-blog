package com.blog.core.system.user.service.impl;

import com.blog.core.system.role.dto.ManageRoleIdDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import com.blog.core.system.user.service.ManageUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageUserServiceImplTest {

    @Autowired
    private ManageUserService manageUserService;

    @Test
    public void queryUserByPage() {
    }

    @Test
    public void queryUserByUserId() {
    }

    @Test
    public void queryUserByUserName() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void editManageUser() {
//        List<ManageRoleIdDTO> roles = new ArrayList<>();
//        ManageRoleIdDTO manageRoleIdDTO = new ManageRoleIdDTO();
//        manageRoleIdDTO.setRoleId("86548586a46f422aa6f9e702bbbd04c5");
//        roles.add(manageRoleIdDTO);
//        ManageUserEditDTO manageUserEditDTO = ManageUserEditDTO.builder()
//                .userId("8e20ed1dc3084825800957a89d2061d3")
//                .userName("测试")
//                .gender("1")
//                .email("test@163.com")
//                .telephone("172124576789")
//                .roles(roles)
//                .build();
//        this.manageUserService.editManageUser(manageUserEditDTO);
    }

    @Test
    public void disableUserByUserId() {
    }

    @Test
    public void enableUserByUserId() {
    }
}
