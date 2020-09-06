package com.blog.core.service.impl;

import com.blog.core.dao.NoticeMapper;
import com.blog.core.dao.RocketmqTransactionLogMapper;
import com.blog.core.entity.Notice;
import com.blog.core.entity.RocketmqTransactionLog;
import com.blog.core.entity.TaskHandHandler;
import com.blog.core.service.TestProducerService;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: TestProducerService
 * @description:
 * @author: 950103
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

	@Override
	public List<Notice> query() {
		return this.noticeMapper.query();
	}

	@TaskHandHandler(type = "dasd")
	@Override
	public List<Notice> query(Notice notice) {
		return this.noticeMapper.query();
	}

	@Transactional
	@Override
	public void insert() {
		System.out.println("====");
		List<Notice> list = new ArrayList<>(5000000);
		for(int i= 5000000;i< 10000000;i++) {
			Notice notice = new Notice();
			notice.setId(i);
			notice.setContent("测试"+i);
			list.add(notice);
		}
		System.out.println("构造完成");
		int count = list.size() / 100;
		for (int i = 0; i <= count; i++) {
			List<Notice> paramList = null;
			if (i == count) {
				paramList = list.subList(100 * i, list.size());
			} else {
				paramList = list.subList(100 * i, (100 * (i + 1)));
			}
			if (paramList.size() > 0) {
				System.out.println("插入");
				this.noticeMapper.insert(paramList);
			}
		}
	}
}
