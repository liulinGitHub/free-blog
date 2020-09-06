package com.blog.core.system.auth.dao;

import com.blog.core.system.auth.vo.ManageUserInfoVO;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/3/31 16:40
 * @version: 1.0
 **/
@Repository("manageAuthMapper")
public interface ManageAuthMapper {

    ManageUserInfoVO selectUserInfoByUserId(Integer userId);
}
