package com.blog.core.common.command;

import lombok.Data;

/**
 * @ClassNmae: AbstractCommand
 * @description:
 * @Author: liulin
 * @Date: 2019/12/19 23:42
 **/
@Data
public abstract class AbstractCommand<Result> {


    public abstract Result execute(ICommandInvoker context);

    /**任务结果**/
    private Result result;

    /**命令执行的上下文**/
    protected ICommandInvoker context;

    /**多线程执行时，记录异常**/
    protected Throwable error;
}
