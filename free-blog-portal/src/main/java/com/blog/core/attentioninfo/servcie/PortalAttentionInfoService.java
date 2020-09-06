package com.blog.core.attentioninfo.servcie;

import com.blog.core.attentioninfo.dto.AttentionDTO;
import com.blog.core.attentioninfo.vo.AttentionUserVO;

import java.util.List;

/**
 * @program: PortalAttentionInfoService
 * @description: 关注信息Service
 * @author: 950103
 * @create: 2020-04-29 17:24
 * @Version: 1.0
 */
public interface PortalAttentionInfoService {

	/**
	 * 根据用户ID查询被关注的用户信息
	 *
	 * @param userId
	 * @return
	 **/
	List<AttentionUserVO> queryBeAttentionInfo(Integer userId);

	/**
	 * 根据用户ID查询所有的关注人信息
	 *
	 * @param userId
	 * @return
	 **/
	List<AttentionUserVO> queryAttentionInfo(Integer userId);

	/**
	 * 添加关注
	 *
	 * @param attentionDTOO
	 * @return
	 **/
	void savePortalAttention(AttentionDTO attentionDTOO);

	/**
	 * 取消关注
	 *
	 * @param attentionDTOO
	 * @return
	 **/
	void cancelPortalAttention(AttentionDTO attentionDTOO);
}
