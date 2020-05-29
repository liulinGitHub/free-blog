package com.blog.core.attentioninfo.controller;

import com.blog.core.attentioninfo.servcie.PortalAttentionInfoService;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: PortalUserAttentionController
 * @description: 关注信息Controller
 * @author: liulin
 * @create: 2020-04-29 16:53
 * @Version: 1.0
 */
@Api(value = "关注信息Controller",tags = "关注信息服务")
@RestController
public class PortalAttentionInfoController {

	@Autowired
	private PortalAttentionInfoService portalAttentionInfoService;

	@ApiOperation(value="获取用户被关注人信息", notes="")
	@GetMapping("/beAttention/{userId}")
	public ResponseBo queryBeAttentionInfo(@PathVariable String userId) {
		return ResponseBo.newDataResponse(this.portalAttentionInfoService.queryBeAttentionInfo(userId));
	}

	@ApiOperation(value="获取用户关注人信息", notes="")
	@GetMapping("/attention/{userId}")
	public ResponseBo queryAttentionInfo(@PathVariable String userId) {
		return ResponseBo.newDataResponse(this.portalAttentionInfoService.queryAttentionInfo(userId));
	}

	@ApiOperation(value="添加关注", notes="")
	@GetMapping("/attention/add/{userId}")
	public ResponseBo addAttention(@PathVariable String userId) {
		this.portalAttentionInfoService.addAttention(userId);
		return ResponseBo.ok("添加关注成功！");
	}

	@ApiOperation(value="取消关注", notes="")
	@GetMapping("/attention/cancel/{userId}")
	public ResponseBo cancelAttention(@PathVariable String userId) {
		this.portalAttentionInfoService.cancelAttention(userId);
		return ResponseBo.ok("取消关注成功！");
	}


}
