package com.blog.core.tag.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalTag
 * @description:
 * @author: 950103
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
    private EnableEnum enable;
}
