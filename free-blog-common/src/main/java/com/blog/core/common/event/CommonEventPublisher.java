package com.blog.core.common.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @program: CommonEventPublisher
 * @description:
 * @author: liulin
 * @create: 2019-05-15 11:49
 * @Version: 1.0
 */
@Service
public class CommonEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 发送消息
     * @param messageEvent
     */
    public void publish(AbstractEvent messageEvent) {
        eventPublisher.publishEvent(messageEvent);
    }
}
