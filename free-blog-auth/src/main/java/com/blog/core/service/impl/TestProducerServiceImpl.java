package com.blog.core.service.impl;

import com.blog.core.dao.NoticeMapper;
import com.blog.core.dao.RocketmqTransactionLogMapper;
import com.blog.core.entity.Notice;
import com.blog.core.entity.RocketmqTransactionLog;
import com.blog.core.service.TestProducerService;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @program: TestProducerService
 * @description:
 * @author: liulin
 * @create: 2020-05-30 17:12
 * @Version: 1.0
 */
@Service
public class TestProducerServiceImpl implements TestProducerService {

	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	@Autowired
	private NoticeMapper noticeMapper;

	@Autowired
	private RocketmqTransactionLogMapper rocketmqTransactionLogMapper;

	@Override
	public String testSendMsg(Notice notice) {
		String topic = "Notice-topic";
		// 生产者所在的事务组
		String txProducerGroup = "notice-producer-group";

		// 生产事务id
		String transactionId = UUID.randomUUID().toString();

		rocketMQTemplate.sendMessageInTransaction(txProducerGroup, topic,
				MessageBuilder.withPayload("事物消息")
						.setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
						.setHeader("notice_id", notice.getId())
						.build(),
				notice
		);
		return "send message success";
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateNotice(Integer noticeId, Notice notice) {
		Notice newNotice = new Notice();
		newNotice.setId(noticeId);
		newNotice.setContent(notice.getContent());

		noticeMapper.updateByPrimaryKeySelective(newNotice);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateNoticeWithRocketMQLog(Integer noticeId, Notice notice, String transactionId) {
		updateNotice(noticeId, notice);
		// 写入事务日志
		rocketmqTransactionLogMapper.insertSelective(
				RocketmqTransactionLog.builder()
						.transactionId(transactionId)
						.log("updateNotice")
						.build()
		);
	}
}
