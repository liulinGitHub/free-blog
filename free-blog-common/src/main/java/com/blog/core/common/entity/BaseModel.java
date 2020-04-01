package com.blog.core.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: free-blog
 * @description: model公共类
 * @author: liulin
 * @create: 2019-04-30 14:06
 */
@Data
public class BaseModel {

    @ApiModelProperty("创建人")
    private String createId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建人")
    private String updateId;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
