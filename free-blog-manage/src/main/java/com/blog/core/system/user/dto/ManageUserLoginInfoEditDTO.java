package com.blog.core.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @program: ManageUserLoginInfoEditDTO
 * @description: 用户登录相关信息
 * @author: liulin
 * @create: 2020-04-02 17:31
 * @Version: 1.0
 */
@Data
@Builder
public class ManageUserLoginInfoEditDTO {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("上次登录IP")
    private String lastLoginIp;

    @ApiModelProperty("上次登录时间")
    private Date lastLoginTime;

    @ApiModelProperty("修改人")
    private String updateId;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
