package com.blog.core.attentioninfo.dao;

import com.blog.core.attentioninfo.entity.PortalUserAttention;

import java.util.List;

/**
 * @ClassName: PortalAttentionInfoMapper
 * @description: 关注信息Service
 * @author: 950103
 * @create: 2020-07-20 15:18
 * @Version: 1.0
 */
public interface PortalAttentionInfoMapper {

	/**
	 * 根据用户ID查询被关注的用户信息
	 *
	 * @param userId
	 * @return
	 **/
	List<Integer> selectBeAttentionInfo(Integer userId);

	/**
	 * 根据用户ID查询关注的用户信息
	 *
	 * @param userId
	 * @return
	 **/
	List<Integer> selectAttentionInfo(Integer userId);

	/**
	 * 添加用户关注信息
	 *
	 * @param portalUserAttention
	 * @return
	 **/
	int insertPortalAttention(PortalUserAttention portalUserAttention);

	/**
	 * 取消用户关注信息
	 *
	 * @param portalUserAttention
	 * @return
	 **/
	int cancelPortalAttention(PortalUserAttention portalUserAttention);

}
