package com.blog.core.comment.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.comment.vo.PortalCommentTree;
import com.blog.core.comment.service.PortalCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: PortalCommentServiceImpl
 * @description:
 * @author: 950103
 * @create: 2020-07-17 10:16
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PortalCommentServiceImplTest {

	@Autowired
	private PortalCommentService portalCommentService;

	@Test
	public void queryPortalCommentTree() {
		String articleId = "1";
		List<PortalCommentTree> portalCommentTreeList = portalCommentService.queryPortalCommentTree(articleId);
		System.out.println(JSONObject.toJSONString(portalCommentTreeList));
	}
}

