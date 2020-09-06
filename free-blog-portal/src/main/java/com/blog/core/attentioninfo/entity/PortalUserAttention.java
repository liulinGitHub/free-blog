package com.blog.core.attentioninfo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PortalUserAttention
 * @description: 用户关注信息
 * @author: 950103
 * @create: 2020-07-20 15:12
 * @Version: 1.0
 */
@Builder
@Data
public class PortalUserAttention {

	@ApiModelProperty("关注ID")
	private Integer attentionId;

	@ApiModelProperty("用户ID")
	private Integer attentionUserId;

	@ApiModelProperty("关注用户ID")
	private Integer beAttentionUserId;

	@ApiModelProperty("关注时间")
	private Date attentionTime;

	@ApiModelProperty("取消关注时间")
	private Date cancelAttentionTime;

	@ApiModelProperty("启用/停用")
	private String enable;
}
