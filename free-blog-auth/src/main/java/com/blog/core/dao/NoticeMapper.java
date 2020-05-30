package com.blog.core.dao;

import com.blog.core.entity.Notice;
import org.apache.ibatis.annotations.Update;

/**
 * @program: NoticeMapper
 * @description:
 * @author: liulin
 * @create: 2020-05-30 17:21
 * @Version: 1.0
 */
public interface NoticeMapper {

	@Update("update notice set content = #{content} where id = #{id}")
	void updateByPrimaryKeySelective(Notice notice);
}
