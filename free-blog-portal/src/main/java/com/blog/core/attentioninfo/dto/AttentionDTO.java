package com.blog.core.attentioninfo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: AttentionDTO
 * @description: 关注信息参数
 * @author: 950103
 * @create: 2020-07-20 15:01
 * @Version: 1.0
 */
@Data
public class AttentionDTO {

	@ApiModelProperty("添加关注的用户id")
	private Integer attentionUserId;

	@ApiModelProperty("被关注的用户id")
	private Integer beAttentionUserId;
}
