package com.blog.core.consumer;

import com.blog.core.dao.RocketmqTransactionLogMapper;
import com.blog.core.entity.Notice;
import com.blog.core.entity.RocketmqTransactionLog;
import com.blog.core.service.TestProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @program: TestTransactionListener
 * @description:
 * @author: liulin
 * @create: 2020-05-30 17:19
 * @Version: 1.0
 */
@Slf4j
@RequiredArgsConstructor
@RocketMQTransactionListener(txProducerGroup = "notice-producer-group")
public class TestTransactionListener implements RocketMQLocalTransactionListener {

	private final TestProducerService service;
	private final RocketmqTransactionLogMapper rocketmqTransactionLogMapper;

	@Override
	public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		MessageHeaders headers = msg.getHeaders();
		String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
		log.info("执行本地事务方法. 事务id: {}", transactionId);
		// header里拿出来的都是String类型
		Integer noticeId = Integer.parseInt((String) headers.get("notice_id"));

		try {
			// 执行带有事务注解的方法
			service.updateNoticeWithRocketMQLog(noticeId, (Notice) arg, transactionId);
			// 正常执行，向MQ Server发送commit消息
			return RocketMQLocalTransactionState.COMMIT;
		} catch (Exception e) {
			log.error("本地事务方法发生异常，消息将被回滚", e);
			// 发生异常向MQ Server发送rollback消息
			return RocketMQLocalTransactionState.ROLLBACK;
		}
	}

	/**
	 * 用于回查本地事务的执行结果
	 */
	@Override
	public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
		MessageHeaders headers = msg.getHeaders();
		String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
		log.warn("回查本地事务状态. 事务id: {}", transactionId);

		// 按事务id查询日志数据
		RocketmqTransactionLog transactionLog = rocketmqTransactionLogMapper.selectOne(transactionId);

		// 如果能按事务id查询出来数据表示本地事务执行成功，没有数据则表示本地事务执行失败
		if (transactionLog == null) {
			log.warn("本地事务执行失败，事务日志不存在，消息将被回滚. 事务id: {}", transactionId);
			return RocketMQLocalTransactionState.ROLLBACK;
		}
		return RocketMQLocalTransactionState.COMMIT;
	}
}
