package com.blog.core.log.entity.domain;

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

    @ApiModelProperty(value="日志id",name="username")
    private String id;

    @ApiModelProperty(value="描述",name="operation")
    private String operation;

    @ApiModelProperty(value="请求方式",name="requestMethod")
    private String requestMethod;

    @ApiModelProperty(value="'请求路径'",name="requestPath")
    private String requestPath;

    @ApiModelProperty(value="'请求方法名称'",name="methodName")
    private String methodName;

    @ApiModelProperty(value="'请求参数'",name="requestParams")
    private String requestParams;

    @ApiModelProperty(value="'请求ip地址'",name="ipAddress")
    private String ipAddress;

    @ApiModelProperty(value="'操作时间'",name="operatingTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operatingTime;

    @ApiModelProperty(value="结果（1： 成功 ；0：失败）",name="resultType")
    private String resultType;

    @ApiModelProperty(value="结果描述",name="resultOperation")
    private String resultOperation;

    @ApiModelProperty(value="'消耗时间'",name="timeConsuming")
    private Long timeConsuming;

    @ApiModelProperty(value="'操作人id'",name="operatingId")
    private String operatingId;

    @ApiModelProperty(value="'操作人'",name="operatingUserName")
    private String operatingUserName;
}
