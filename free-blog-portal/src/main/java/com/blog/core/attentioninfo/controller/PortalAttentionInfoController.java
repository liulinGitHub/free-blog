package com.blog.core.attentioninfo.controller;

import com.blog.core.attentioninfo.dto.AttentionDTO;
import com.blog.core.attentioninfo.servcie.PortalAttentionInfoService;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName: PortalUserAttentionController
 * @description: 关注信息Controller
 * @author: 950103
 * @create: 2020-04-29 16:53
 * @Version: 1.0
 */
@Api(value = "关注信息Controller",tags = "关注信息服务")
@RestController
@RequestMapping("/attention")
public class PortalAttentionInfoController {

	@Autowired
	private PortalAttentionInfoService portalAttentionInfoService;

	@ApiOperation(value="获取被关注人的用户信息", notes="")
	@GetMapping("/beAttention/{userId}")
	public ResponseBo queryBeAttentionInfo(@PathVariable Integer userId) {
		return ResponseBo.newDataResponse(this.portalAttentionInfoService.queryBeAttentionInfo(userId));
	}

	@ApiOperation(value="获取用户关注人信息", notes="")
	@GetMapping("/get/{userId}")
	public ResponseBo queryAttentionInfo(@PathVariable("userId") Integer userId) {
		return ResponseBo.newDataResponse(this.portalAttentionInfoService.queryAttentionInfo(userId));
	}

	@ApiOperation(value="添加关注", notes="")
	@PostMapping("/save")
	public ResponseBo savePortalAttention(@RequestBody @Valid AttentionDTO attentionSaveDTO) {
		this.portalAttentionInfoService.savePortalAttention(attentionSaveDTO);
		return ResponseBo.ok("添加关注成功！");
	}

	@ApiOperation(value="取消关注", notes="")
	@PostMapping("/cancel")
	public ResponseBo cancelAttention(@RequestBody @Valid AttentionDTO attentionSaveDTO) {
		this.portalAttentionInfoService.cancelPortalAttention(attentionSaveDTO);
		return ResponseBo.ok("取消关注成功！");
	}
}
