package com.blog.core.system.user.service.impl;

import com.blog.core.system.user.dao.ManageUserMapper;
import com.blog.core.system.user.entity.dto.ManageUserAddDTO;
import com.blog.core.system.user.entity.dto.ManageUserEditDTO;
import com.blog.core.system.user.entity.vo.ManageUserVO;
import com.blog.core.system.user.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae: ManageUserServiceImpl
 * @description: 用户信息service
 * @Author: liulin
 * @Date: 2019/11/24 1:10
 **/
@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Override
    public List<ManageUserVO> queryArticleByPage() {
        return null;
    }

    @Override
    public ManageUserVO queryUserByUserId(String userId) {
        return null;
    }

    @Override
    public void addUser(ManageUserAddDTO manageUserAddDTO) {

    }

    @Override
    public void editUser(ManageUserEditDTO manageUserEditDTO) {

    }

    @Override
    public void disableUserByUserId(String userId) {

    }

    @Override
    public void enableUserByUserId(String userId) {

    }
}
