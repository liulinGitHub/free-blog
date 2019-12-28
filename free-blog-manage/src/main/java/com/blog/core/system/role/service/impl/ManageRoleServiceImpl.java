package com.blog.core.system.role.service.impl;

import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.vo.ManageRoleMenuInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ManageRoleServiceImpl
 * @description: 角色service实现类
 * @author: liulin
 * @create: 2019-12-28 14:09
 * @Version: 1.0
 */
@Service
public class ManageRoleServiceImpl implements ManageRoleService {


    @Override
    public List<ManageRoleMenuInfoVO> queryRoleMenuInfoByUserId(String userId) {
        return null;
    }
}
