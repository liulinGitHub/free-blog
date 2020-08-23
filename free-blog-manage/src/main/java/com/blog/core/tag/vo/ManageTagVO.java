package com.blog.core.tag.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 标签返回参数
 * @author: 950103
 * @create: 2019-11-22 14:52
 * @Version: 1.0
 */
@Data
public class ManageTagVO {

    @ApiModelProperty("标签ID")
    private String tagId;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
