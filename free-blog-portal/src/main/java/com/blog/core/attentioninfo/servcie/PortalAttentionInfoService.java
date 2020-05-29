package com.blog.core.attentioninfo.servcie;

import com.blog.core.attentioninfo.AttentionUserVO;

import java.util.List;

/**
 * @program: PortalAttentionInfoService
 * @description: 关注信息Service
 * @author: liulin
 * @create: 2020-04-29 17:24
 * @Version: 1.0
 */
public interface PortalAttentionInfoService {

	List<AttentionUserVO> queryBeAttentionInfo(String userId);

	List<AttentionUserVO> queryAttentionInfo(String userId);

	void addAttention(String userId);

	void cancelAttention(String userId);
}
