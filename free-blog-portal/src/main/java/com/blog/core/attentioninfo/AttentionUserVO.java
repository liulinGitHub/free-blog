package com.blog.core.attentioninfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: AttentionUserVO
 * @description: 关注的用户信息
 * @author: liulin
 * @create: 2020-04-29 17:34
 * @Version: 1.0
 */
@Data
public class AttentionUserVO {

	@ApiModelProperty("用户id")
	private String userId;

	@ApiModelProperty("用户昵称")
	private String nickName;

	@ApiModelProperty("用户头像")
	private String userImage;
}
