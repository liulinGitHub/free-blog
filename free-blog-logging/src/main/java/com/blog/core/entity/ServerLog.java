package com.blog.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: ServerLog
 * @description: 系统操作日志
 * @Author: 950103
 * @Date: 2019/4/7 23:13
 **/

@Data
@Api(value = "操作日志")
public class ServerLog {

    @ApiModelProperty("日志id")
    private String logId;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("请求方式")
    private String requestMethod;

    @ApiModelProperty("请求路径")
    private String requestPath;

    @ApiModelProperty("请求方法名称")
    private String methodName;

    @ApiModelProperty("'请求参数'")
    private String requestParams;

    @ApiModelProperty("请求ip地址")
    private String ipAddress;

    @ApiModelProperty("请求地址")
    private String address;

    @ApiModelProperty("浏览器")
    private String browser;

    @ApiModelProperty("操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operatingTime;

    @ApiModelProperty("结果（1： 成功 ；0：失败）")
    private String resultType;

    @ApiModelProperty("结果描述")
    private String resultOperation;

    @ApiModelProperty("消耗时间")
    private Long timeConsuming;

    @ApiModelProperty("操作人id")
    private String operatingId;

    @ApiModelProperty("操作人")
    private String operatingUserName;
}
