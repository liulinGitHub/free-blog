package com.blog.core.system.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalCommonUser
 * @Description: 公共用户信息
 * @Author: 950103
 * @Date: 2020/4/21 22:48
 * @Version 1.0
 */
@Data
public class PortalCommonUser {
    
    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;
}
