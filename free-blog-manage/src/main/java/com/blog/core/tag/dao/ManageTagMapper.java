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
    ManageTagVO selectManageTagByTagId(String tagId);

    /**
     * @Author liulin
     * @Description 添加标签信息
     * @Date 2020/1/18 14:11
     * @param manageTag
     * @return void
     **/
    void insertManageTag(ManageTag manageTag);

    /**
     * @Author liulin
     * @Description 修改标签信息
     * @Date 2020/1/18 14:11
     * @param manageTag
     * @return void
     **/
    void updateManageTag(ManageTag manageTag);

    /**
     * @Author liulin
     * @Description 删除标签信息
     * @Date 2020/1/18 14:11
     * @param list
     * @return void
     **/
    void deleteManageTagByTagId(List<String> list);

    /**
     * @Author ll
     * @Description 修改标签为启用
     * @Date 2020/2/2 14:12
     * @Param [list]
     * @return void
     **/
    void updateEnableManageTagByTagId(List<String> list);

    /**
     * @Author ll
     * @Description 修改标签为停用
     * @Date 2020/2/2 14:12
     * @Param [list]
     * @return void
     **/
    void updateDisableManageTagByTagId(List<String> list);

    void add(ManageTag manageTag);
}
