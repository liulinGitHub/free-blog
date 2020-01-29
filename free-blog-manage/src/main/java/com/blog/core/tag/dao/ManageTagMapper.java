package com.blog.core.tag.dao;

import com.blog.core.tag.dto.ManageTagAddDTO;
import com.blog.core.tag.dto.ManageTagEditDTO;
import com.blog.core.tag.dto.ManageTagIdDTO;
import com.blog.core.tag.vo.ManageTagListVO;
import com.blog.core.tag.vo.ManageTagVO;

import java.util.List;

/**
 * @program: ManageTagMapper
 * @description:
 * @author: liulin
 * @create: 2020-01-18 14:13
 * @Version: 1.0
 */
public interface ManageTagMapper {

    /**
     * @Author liulin
     * @Description 分页获取标签详情
     * @Date 2020/1/18 14:08
     * @param
     * @return java.util.List<com.blog.core.tag.vo.ManageTagListVO>
     **/
    List<ManageTagListVO> selectManageTagByPage();

    /**
     * @Author liulin
     * @Description 根据标签id查询标签详情
     * @Date 2020/1/18 14:08
     * @param tagId
     * @return com.blog.core.tag.vo.ManageTagVO
     **/
    ManageTagVO selectManageTagByTagId(Integer tagId);

    /**
     * @Author liulin
     * @Description 添加标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagAddDTO
     * @return void
     **/
    void insertManageTag(ManageTagAddDTO manageTagAddDTO);

    /**
     * @Author liulin
     * @Description 修改标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagEditDTO
     * @return void
     **/
    void updateManageTag(ManageTagEditDTO manageTagEditDTO);

    /**
     * @Author liulin
     * @Description 删除标签信息
     * @Date 2020/1/18 14:11
     * @param manageTagIdDTO
     * @return void
     **/
    void deleteManageTagByTagId(ManageTagIdDTO manageTagIdDTO);
}
