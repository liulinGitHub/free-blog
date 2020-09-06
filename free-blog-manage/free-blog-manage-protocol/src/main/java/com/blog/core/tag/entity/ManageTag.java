package com.blog.core.tag.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ManageTag
 * @description:
 * @Author: 950103
 * @Date: 2020/2/2 12:47
 **/
@Data
public class ManageTag extends BaseModel {

    @ApiModelProperty("标签id")
    private Integer tagId;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("标签分类id")
    private Integer tagCateGoryId;

    @ApiModelProperty("停用/启用")
    private EnableEnum enable;
}
