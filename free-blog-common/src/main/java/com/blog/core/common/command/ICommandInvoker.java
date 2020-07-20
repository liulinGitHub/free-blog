package com.blog.core.common.command;

/**
 * @ClassName: ICommandInvoker
 * @description:
 * @Author: 950103
 * @Date: 2019/12/19 23:43
 **/
public interface ICommandInvoker {

    <Result> Result invoke(AbstractCommand<Result> command);
}
