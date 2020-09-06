package com.blog.core.tag.dao;

import com.blog.core.tag.entity.ManageTag;
import com.blog.core.tag.vo.ManageTagListVO;
import com.blog.core.tag.vo.ManageTagVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2020-01-18 14:13
 * @Version: 1.0
 */
@Repository("manageTagMapper")
public interface ManageTagMapper {

    /**
     * 分页获取标签详情
     *
     * @return
     **/
    List<ManageTagListVO> selectManageTagByPage();

    /**
     * 根据标签id查询标签详情
     *
     * @param tagId
     * @return
     **/
    ManageTagVO selectManageTagByTagId(String tagId);

    /**
     * 添加标签信息
     *
     * @param manageTag
     * @return void
     **/
    void insertManageTag(ManageTag manageTag);

    /**
     * 修改标签信息
     *
     * @param manageTag
     * @return void
     **/
    void updateManageTag(ManageTag manageTag);

    /**
     * 删除标签信息
     *
     * @return void
     **/
    void deleteManageTagByTagId(List<Integer> list);

    /**
     * 修改标签为启用
     *
     * @return void
     **/
    void updateEnableManageTagByTagId(List<Integer> list);

    /**
     * 修改标签为停用
     *
     * @return void
     **/
    void updateDisableManageTagByTagId(List<Integer> list);

    void add(ManageTag manageTag);
}
