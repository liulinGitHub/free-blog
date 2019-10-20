package com.blog.core.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @program: AbstractEvent
 * @description:
 * @author: liulin
 * @create: 2019-05-15 11:50
 * @Version: 1.0
 */
public abstract class AbstractEvent<T> extends ApplicationEvent {

    public AbstractEvent(T t) {
        super(t);
    }

    @Override
    public T getSource(){
        return (T) super.getSource();
    }


}
