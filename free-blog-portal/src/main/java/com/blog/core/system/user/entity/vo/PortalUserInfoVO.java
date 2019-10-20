package com.blog.core.system.user.entity.vo;

import com.blog.core.system.role.entity.vo.PortalRoleVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: UserInfoVO
 * @description: 用户信息
 * @author: liulin
 * @create: 2019-06-28 16:30
 * @Version: 1.0
 */
@Data
public class PortalUserInfoVO {

    @ApiModelProperty(value="用户id",name="userName")
    private String userId;

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @ApiModelProperty(value="上一次登陆时间",name="lastLoginTime")
    private Date lastLoginTime;

    @ApiModelProperty(value="个性签名",name="signature")
    private String signature;

    @ApiModelProperty(value="发布评论数",name="comments")
    private Long comments;

    @ApiModelProperty(value="文章数",name="posts")
    private Long articleTotal;

    @ApiModelProperty(value="性别",name="gender")
    private String gender;

    private List<PortalRoleVO> roleVOList;
}
