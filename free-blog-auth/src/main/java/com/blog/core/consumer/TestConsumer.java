package com.blog.core.consumer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

/**
 * @program: TestConsumer
 * @description:
 * @author: liulin
 * @create: 2020-05-29 16:50
 * @Version: 1.0
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "test_consumer_group")
public class TestConsumer implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {

	@Override
	public void onMessage(String message) {
		System.out.println(JSONObject.toJSONString(message));
	}

	@Override
	public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
		defaultMQPushConsumer.setMaxReconsumeTimes(0);
	}
}
