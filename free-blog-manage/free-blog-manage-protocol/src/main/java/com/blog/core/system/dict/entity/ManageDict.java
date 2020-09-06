package com.blog.core.system.dict.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 数据字典
 * @date: 2020/8/23 17:43
 * @author: 950103
 * @version: 1.0
 */
@Data
public class ManageDict extends BaseModel {

    @ApiModelProperty("数据字典id")
    private Integer dictId;

    @ApiModelProperty("字段")
    private String fieldType;

    @ApiModelProperty("描述")
    private String remark;
}
