package com.blog.core.tag.service;

import com.blog.core.tag.entity.vo.ManageTagVO;

import java.util.List;

/**
 * @program: ManageTagService
 * @description:
 * @author: liulin
 * @create: 2019-12-16 15:18
 * @Version: 1.0
 */
public interface ManageTagService {

    /**
     * 查询标签信息
     * @return
     */
    List<ManageTagVO> queryManageTagByPage();
}
