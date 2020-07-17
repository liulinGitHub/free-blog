package com.blog.core.dao;

import com.blog.core.entity.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

	@Insert("<script>" +
			"insert into notice (id,content) values <foreach collection='list' item='item' index='index' separator=','>" +
			"(#{item.id},#{item.content})"+
			"</foreach>"+
			"</script>")
	void insert(@Param("list") List<Notice> list);

	@Select("select content,id from notices")
	List<Notice> query();
}
