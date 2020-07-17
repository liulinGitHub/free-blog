package com.blog.core.service;

import com.blog.core.entity.Notice;

import java.util.List;

/**
 * @program: TestProducerService
 * @description:
 * @author: liulin
 * @create: 2020-05-30 17:37
 * @Version: 1.0
 */
public interface TestProducerService {

	String testSendMsg(Notice notice);

	void updateNotice(Integer noticeId, Notice notice);

	void updateNoticeWithRocketMQLog(Integer noticeId, Notice notice, String transactionId);

	List<Notice> query();

	List<Notice> query(Notice notice);

	void insert();
}
