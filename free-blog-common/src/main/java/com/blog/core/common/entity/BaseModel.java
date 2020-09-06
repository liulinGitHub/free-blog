package com.blog.core.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: model公共类
 * @author: 950103
 * @create: 2019-04-30 14:06
 * @version: 1.0
 */
@Data
public class BaseModel {

    @ApiModelProperty("创建人")
    private Integer createId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人")
    private Integer updateId;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
