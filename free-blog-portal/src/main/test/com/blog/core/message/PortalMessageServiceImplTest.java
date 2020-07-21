package com.blog.core.message;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.common.enums.MessageTypeEnum;
import com.blog.core.message.dto.PortalMessageAddDTO;
import com.blog.core.message.dto.PortalMessageQueryDTO;
import com.blog.core.message.service.PortalMessageService;
import com.blog.core.message.vo.PortalMessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: PortalMessageServiceImplTest
 * @description: 消息测试类
 * @author: 950103
 * @create: 2020-07-21 14:21
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PortalMessageServiceImplTest {

	@Autowired
	private PortalMessageService portalMessageService;

	@Test
	public void queryPortalMessageByPage() {
		PortalMessageQueryDTO portalMessageQueryDTO = new PortalMessageQueryDTO();
		portalMessageQueryDTO.setUserId("1");
		portalMessageQueryDTO.setMessageType(MessageTypeEnum.MESSAGE_REPLY);
		List<PortalMessageVO> portalMessageVOS = this.portalMessageService.queryPortalMessageByPage(portalMessageQueryDTO);
		System.out.println(JSONObject.toJSONString(portalMessageVOS));
	}

	@Test
	public void savePortalMessage() {
		PortalMessageAddDTO portalMessageAddDTO = new PortalMessageAddDTO();
		portalMessageAddDTO.setReceiveId("1");
		portalMessageAddDTO.setReceiveTime(new Date());
		portalMessageAddDTO.setSendId("2");
		portalMessageAddDTO.setSendTime(new Date());
		portalMessageAddDTO.setContent("测试消息");
		portalMessageAddDTO.setMessageType(MessageTypeEnum.MESSAGE_REPLY);
		this.portalMessageService.savePortalMessage(portalMessageAddDTO);
	}
}
