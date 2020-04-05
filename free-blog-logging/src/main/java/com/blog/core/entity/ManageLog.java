package com.blog.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: SysBaseLog
 * @description: 操作日志
 * @Author: liulin
 * @Date: 2019/4/7 23:13
 **/

@Data
@Api(value = "操作日志")
public class ManageLog {

    @ApiModelProperty(value="日志id")
    private String logId;

    @ApiModelProperty(value="描述")
    private String description;

    @ApiModelProperty(value="请求方式")
    private String requestMethod;

    @ApiModelProperty(value="请求路径")
    private String requestPath;

    @ApiModelProperty(value="请求方法名称")
    private String methodName;

    @ApiModelProperty(value="'请求参数'")
    private String requestParams;

    @ApiModelProperty(value="请求ip地址")
    private String ipAddress;

    @ApiModelProperty(value="请求地址")
    private String address;

    @ApiModelProperty(value="浏览器")
    private String browser;

    @ApiModelProperty(value="操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operatingTime;

    @ApiModelProperty(value="结果（1： 成功 ；0：失败）")
    private String resultType;

    @ApiModelProperty(value="结果描述")
    private String resultOperation;

    @ApiModelProperty(value="消耗时间")
    private Long timeConsuming;

    @ApiModelProperty(value="操作人id")
    private String operatingId;

    @ApiModelProperty(value="操作人")
    private String operatingUserName;
}
