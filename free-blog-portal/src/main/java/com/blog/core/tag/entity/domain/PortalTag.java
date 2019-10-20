package com.blog.core.tag.entity.domain;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.IsEnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ManageTag
 * @description:
 * @author: liulin
 * @create: 2019-07-23 17:58
 * @Version: 1.0
 */
@Data
public class PortalTag extends BaseModel {

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("标签类别名称ID")
    private String tagCategoryId;

    @ApiModelProperty("启用/停用")
    private IsEnableEnum isEnable;
}
