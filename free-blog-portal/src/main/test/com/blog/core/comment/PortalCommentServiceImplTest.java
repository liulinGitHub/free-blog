package com.blog.core.comment;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.comment.dto.PortalApprovalCommentDTO;
import com.blog.core.comment.dto.PortalCommentAddDTO;
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

	@Test
	public void savePortalComment() {
		PortalCommentAddDTO portalCommentAddDTO = new PortalCommentAddDTO();
		portalCommentAddDTO.setArticleId("1");
		portalCommentAddDTO.setCommentContent("测试评论1");
		this.portalCommentService.savePortalComment(portalCommentAddDTO);
	}

	@Test
	public void approvalPortalComment() {
		PortalApprovalCommentDTO portalApprovalCommentDTO = new PortalApprovalCommentDTO();
		portalApprovalCommentDTO.setSubjectCommentId("a5fcd52ac3a1480ca58d9ec7b215e412");
		portalApprovalCommentDTO.setPostUserId("8e20ed1dc3084825800957a89d2061d2");
		portalApprovalCommentDTO.setCommentContent("测试评论1");
		this.portalCommentService.approvalPortalComment(portalApprovalCommentDTO);
	}
}

