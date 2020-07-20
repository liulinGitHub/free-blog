package com.blog.core.attentioninfo.servcie.impl;

import com.blog.core.attentioninfo.dao.PortalAttentionInfoMapper;
import com.blog.core.attentioninfo.dto.AttentionDTO;
import com.blog.core.attentioninfo.entity.PortalUserAttention;
import com.blog.core.attentioninfo.vo.AttentionUserVO;
import com.blog.core.attentioninfo.servcie.PortalAttentionInfoService;
import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.system.user.service.PortalCommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: PortalAttentionInfoServiceImpl
 * @description: 关注信息Service
 * @author: 950103
 * @create: 2020-04-30 18:15
 * @Version: 1.0
 */
@Slf4j
@Service
public class PortalAttentionInfoServiceImpl implements PortalAttentionInfoService {

	@Autowired
	private PortalAttentionInfoMapper portalAttentionInfoMapper;

	@Autowired
	private PortalCommonUserService portalCommonUserService;

	@Override
	public List<AttentionUserVO> queryBeAttentionInfo(String userId) {
		List<String> beAttentionUserIdList = this.portalAttentionInfoMapper.selectBeAttentionInfo(userId);
		if (CollectionUtils.isEmpty(beAttentionUserIdList)) {
			return new ArrayList<>();
		}
		List<AttentionUserVO> attentionUserVOList = this.portalCommonUserService.queryPortalAttentionUserInfo(beAttentionUserIdList);
		return attentionUserVOList;
	}

	@Override
	public List<AttentionUserVO> queryAttentionInfo(String userId) {
		List<String> attentionUserIdList = this.portalAttentionInfoMapper.selectAttentionInfo(userId);
		if (CollectionUtils.isEmpty(attentionUserIdList)) {
			return new ArrayList<>();
		}
		List<AttentionUserVO> attentionUserVOList = this.portalCommonUserService.queryPortalAttentionUserInfo(attentionUserIdList);
		return attentionUserVOList;
	}

	@Transactional
	@Override
	public void savePortalAttention(AttentionDTO attentionDTOO) {
		PortalUserAttention portalUserAttention = PortalUserAttention.builder()
				.attentionId(UUIDUtil.randomUUID32())
				.attentionUserId(attentionDTOO.getAttentionUserId())
				.beAttentionUserId(attentionDTOO.getBeAttentionUserId())
				.attentionTime(new Date())
				.enable(EnableEnum.Enable_YES.getValue())
				.build();
		this.portalAttentionInfoMapper.insertPortalAttention(portalUserAttention);
	}

	@Transactional
	@Override
	public void cancelPortalAttention(AttentionDTO attentionDTOO) {
		PortalUserAttention portalUserAttention = PortalUserAttention.builder()
				.attentionUserId(attentionDTOO.getAttentionUserId())
				.beAttentionUserId(attentionDTOO.getBeAttentionUserId())
				.cancelAttentionTime(new Date())
				.enable(EnableEnum.Enable_NO.getValue())
				.build();
		this.portalAttentionInfoMapper.cancelPortalAttention(portalUserAttention);
	}
}
