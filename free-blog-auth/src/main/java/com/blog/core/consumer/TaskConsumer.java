package com.blog.core.consumer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: TaskConsumer
 * @description:
 * @author: liulin
 * @create: 2020-05-29 17:11
 * @Version: 1.0
 */
@RestController
@RequiredArgsConstructor
public class TaskConsumer {

	private final RocketMQTemplate rocketMQTemplate;

	@GetMapping("/test-rocketmq/sendMsg")
	public String testSendMsg() {
		String topic = "test-topic";
		// 发送消息
		rocketMQTemplate.convertAndSend(topic, Message.getInstance());

		return "send message success";
	}

}

@Data
class Message {
	private Integer id;
	private String name;
	private String status;
	private Date createTime;

	static Message getInstance() {
		Message message = new Message();
		message.id = 1;
		message.name = "小明";
		message.status = "default";
		message.createTime = new Date();

		return message;
	}
}
