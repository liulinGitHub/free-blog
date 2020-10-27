package com.blog.core.system.auth.dao;

import com.blog.core.system.auth.vo.UserInfoVO;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/3/31 16:40
 * @version: 1.0
 **/
@Repository("authMapper")
public interface AuthMapper {

    UserInfoVO selectUserInfoByUserId(Integer userId);
}
