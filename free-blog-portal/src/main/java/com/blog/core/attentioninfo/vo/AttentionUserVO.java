package com.blog.core.attentioninfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: AttentionUserVO
 * @description: 关注的用户信息
 * @author: 950103
 * @create: 2020-04-29 17:34
 * @Version: 1.0
 */
@Data
public class AttentionUserVO {

	@ApiModelProperty("用户id")
	private Integer userId;

	@ApiModelProperty("用户昵称")
	private String nickName;

	@ApiModelProperty("用户头像")
	private String avatar;
}
