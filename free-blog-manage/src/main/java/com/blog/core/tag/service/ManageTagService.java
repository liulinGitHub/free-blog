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
     * @Author liulin
     * @Description 分页获取标签详情
     * @Date 2020/1/18 14:08
     * @param
     * @return java.util.List<com.blog.core.tag.vo.ManageTagListVO>
     **/
    List<ManageTagListVO> queryManageTagByPage();

    /**
     * @Author liulin
     * @Description 根据标签id查询标签详情
     * @Date 2020/1/18 14:08
     * @param tagId
     * @return com.blog.core.tag.vo.ManageTagVO
     **/
    ManageTagVO queryManageTagByTagId(String tagId);

    /**
     * @Author liulin
     * @Description 添加标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagAddDTO
     * @return void
     **/
    void addManageTag(ManageTagAddDTO manageTagAddDTO);

    /**
     * @Author liulin
     * @Description 修改标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagEditDTO
     * @return void
     **/
    void editManageTag(ManageTagEditDTO manageTagEditDTO);

    /**
     * @Author liulin
     * @Description 删除标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagIdDTO
     * @return void
     **/
    void deleteManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    /**
     * @Author liulin
     * @Description 启用标签
     * @Date 2020/1/18 14:15
     * @param manageTagIdDTO
     * @return void
     **/
    void enableManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    /**
     * @Author liulin
     * @Description 停用标签
     * @Date 2020/1/18 14:16
     * @param manageTagIdDTO
     * @return void
     **/
    void disableManageTagByTagId(ManageTagIdDTO manageTagIdDTO);

    void parent();

    void child();
}
