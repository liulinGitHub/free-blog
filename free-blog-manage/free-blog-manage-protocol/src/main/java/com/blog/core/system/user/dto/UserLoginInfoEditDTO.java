package com.blog.core.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @description: 用户登录相关信息
 * @author: 950103
 * @create_time: 2020-04-02 17:31
 * @version: 1.0
 */
@Data
@Builder
public class UserLoginInfoEditDTO {

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("上次登录IP")
    private String lastLoginIp;

    @ApiModelProperty("上次登录时间")
    private Date lastLoginTime;

    @ApiModelProperty("修改人")
    private Integer updateId;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
