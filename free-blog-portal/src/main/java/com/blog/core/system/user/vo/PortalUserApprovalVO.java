package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalUserApprovalVO
 * @description: 用户点赞信息
 * @Author: 950103
 * @Date: 2020/3/25 21:00
 **/
@Data
public class PortalUserApprovalVO {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;
}
