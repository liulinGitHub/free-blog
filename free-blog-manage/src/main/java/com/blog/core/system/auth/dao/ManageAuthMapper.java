package com.blog.core.system.auth.dao;

import com.blog.core.system.auth.vo.ManageUserInfoVO;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae: ManageAuthMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/3/31 16:40
 **/
@Repository("manageAuthMapper")
public interface ManageAuthMapper {

    ManageUserInfoVO selectUserInfoByUserId(String userId);
}
