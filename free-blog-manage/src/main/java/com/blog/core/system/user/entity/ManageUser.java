package com.blog.core.system.user.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 用户信息
 * @author: 950103
 * @date: 2019/11/24 1:28
 * @version: 1.0
 **/
@Data
public class ManageUser extends BaseModel {

    @ApiModelProperty("用户id")
    private String userId;

    private String userName;

    private String password;

    private String nickName;

    private String avatar;

    private String telephone;

    private String signature;

    private String email;

    private String gender;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String attentionId;

    private EnableEnum enable;
}
