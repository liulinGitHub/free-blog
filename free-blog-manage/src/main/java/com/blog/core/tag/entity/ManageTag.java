package com.blog.core.tag.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.IsEnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageTag
 * @description:
 * @Author: liulin
 * @Date: 2020/2/2 12:47
 **/
@Data
public class ManageTag extends BaseModel {

    @ApiModelProperty("标签id")
    private String tagId;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("标签分类id")
    private String tagCateGoryId;

    @ApiModelProperty("停用/启用")
    private IsEnableEnum isEnable;
}
