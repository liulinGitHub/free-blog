package com.blog.core.consumer;


import com.alibaba.fastjson.JSONObject;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import org.apache.rocketmq.common.message.Message;
/**
 * @description:
 * @author: 950103
 * @create: 2020-05-29 18:14
 * @Version: 1.0
 */
public class SyncProducer {

	public static void main(String[] args) throws Exception {
		//Instantiate with a producer group name.
		DefaultMQProducer producer = new
				DefaultMQProducer("please_rename_unique_group_name");
		// Specify name server addresses.
		producer.setNamesrvAddr("127.0.0.1:9876");
		//Launch the instance.
		producer.start();
		try {
			for (int i = 0; i < 2; i++) {
				//Create a message instance, specifying topic, tag and message body.
				//Call send message to deliver message to one of brokers.
				UserContent userContent = new UserContent(String.valueOf(i),"abc"+i);
				String jsonstr = JSONObject.toJSONString(userContent);
				Message message = new Message("user-topic", "user-tag", jsonstr.getBytes(RemotingHelper.DEFAULT_CHARSET));
				SendResult sendResult = producer.send(message);
				System.out.printf("%s%n", sendResult);
			}
		}catch (Exception e) {
			throw e;
		}
		//Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}
}

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
class UserContent {
	private String username;
	private String pwd;

}
