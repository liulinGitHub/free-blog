package com.blog.core.common.command;

/**
 * @ClassNmae: ICommandInvoker
 * @description:
 * @Author: liulin
 * @Date: 2019/12/19 23:43
 **/
public interface ICommandInvoker {

    <Result> Result invoke(AbstractCommand<Result> command);
}
