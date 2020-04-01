package com.blog.core.system.user.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.IsEnableEnum;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: ManageUser
 * @description: 用户信息
 * @Author: liulin
 * @Date: 2019/11/24 1:28
 **/
@Data
public class ManageUser extends BaseModel {

    private String userId;

    private String userName;

    private String userPassword;

    private String nickName;

    private String avatar;

    private String telephone;

    private String signature;

    private String email;

    private String gender;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String attentionId;

    private IsEnableEnum isEnable;
}
