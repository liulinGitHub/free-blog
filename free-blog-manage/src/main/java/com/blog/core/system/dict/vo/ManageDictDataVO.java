package com.blog.core.system.dict.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @date: 2020/8/23 18:15
 * @author: 950103
 * @version: 1.0
 */
@Data
public class ManageDictDataVO {

    @ApiModelProperty("id")
    private String dictDataId;

    @ApiModelProperty("数据字典id")
    private String dictId;

    @ApiModelProperty("数据名称")
    private String name;

    @ApiModelProperty("数据值")
    private String value;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("创建人")
    private String createName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
