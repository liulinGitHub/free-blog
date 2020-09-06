package com.blog.core.tag.service;

import com.blog.core.tag.dto.ManageTagAddDTO;
import com.blog.core.tag.dto.ManageTagEditDTO;
import com.blog.core.tag.dto.ManageTagIdDTO;
import com.blog.core.tag.vo.ManageTagListVO;
import com.blog.core.tag.vo.ManageTagVO;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2019-12-16 15:18
 * @Version: 1.0
 */
public interface ManageTagService {

    /**
     * 分页获取标签详情
     *
     * @return
     **/
    List<ManageTagListVO> queryManageTagByPage();

    /**
     * 根据标签id查询标签详情
     *
     * @param tagId
     * @return
     **/
    ManageTagVO queryManageTagByTagId(String tagId);

    /**
     * 添加标签信息
     *
     * @return void
     **/
    void addManageTag(ManageTagAddDTO manageTagAddDTO);

    /**
     * 修改标签信息
     *
     * @return void
     **/
    void editManageTag(ManageTagEditDTO manageTagEditDTO);

    /**
     * 删除标签信息
     *
     * @return void
     **/
    void deleteManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    /**
     * 启用标签
     *
     * @return void
     **/
    void enableManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    /**
     * 停用标签
     *
     * @return void
     **/
    void disableManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    void parent();

    void child();
}
