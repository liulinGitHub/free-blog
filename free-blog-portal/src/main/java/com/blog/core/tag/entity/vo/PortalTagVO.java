package com.blog.core.tag.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PortalTagVO
 * @description: 页面标签表VO
 * @author: 950103Scheduler
 * @create: 2019-07-23 17:41
 * @Version: 1.0
 */
@Data
public class PortalTagVO {

    @ApiModelProperty("标签ID")
    private String tagId;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
}
