package com.blog.core.attentioninfo.servcie.impl;

import com.blog.core.attentioninfo.AttentionUserVO;
import com.blog.core.attentioninfo.servcie.PortalAttentionInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PortalAttentionInfoServiceImpl
 * @description:
 * @author: liulin
 * @create: 2020-04-30 18:15
 * @Version: 1.0
 */
@Service
public class PortalAttentionInfoServiceImpl implements PortalAttentionInfoService {

	@Override
	public List<AttentionUserVO> queryBeAttentionInfo(String userId) {
		return null;
	}

	@Override
	public List<AttentionUserVO> queryAttentionInfo(String userId) {
		return null;
	}

	@Override
	public void addAttention(String userId) {

	}

	@Override
	public void cancelAttention(String userId) {

	}
}
