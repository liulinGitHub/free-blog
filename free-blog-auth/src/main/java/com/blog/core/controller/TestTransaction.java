package com.blog.core.controller;

import com.blog.core.entity.Notice;
import com.blog.core.service.TestProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2020-05-30 17:35
 * @Version: 1.0
 */
@RestController
public class TestTransaction {

	@Autowired
	private TestProducerService testProducerService;

	@GetMapping("/testSendMsg")
	public String testSendMsg() {
		Notice notice = new Notice();
		notice.setId(111);
		notice.setContent("测试消息");
		testProducerService.testSendMsg(notice);
		return "send message";
	}

	@GetMapping("/insert")
	public String insert() {
		testProducerService.insert();
		return "send message";
	}

	@GetMapping("/query")
	public List<Notice> query() {
		Notice notice = new Notice();
		notice.setId(111);
		notice.setContent("测试消息");
		return testProducerService.query();
	}

	@GetMapping("/queryTest")
	public List<Notice> queryTest() {
		Notice notice = new Notice();
		notice.setId(111);
		notice.setContent("测试消息");
		return testProducerService.query(notice);
	}
}
