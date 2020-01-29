package com.blog.core.tag.service.impl;

import com.blog.core.tag.dao.ManageTagMapper;
import com.blog.core.tag.dto.ManageTagAddDTO;
import com.blog.core.tag.dto.ManageTagEditDTO;
import com.blog.core.tag.dto.ManageTagIdDTO;
import com.blog.core.tag.service.ManageTagService;
import com.blog.core.tag.vo.ManageTagListVO;
import com.blog.core.tag.vo.ManageTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ManageTagServiceImpl
 * @description:
 * @author: liulin
 * @create: 2019-12-16 15:18
 * @Version: 1.0
 */
@Service
public class ManageTagServiceImpl implements ManageTagService {

    @Autowired
    private ManageTagMapper manageTagMapper;

    @Override
    public List<ManageTagListVO> queryManageTagByPage() {
        return null;
    }

    @Override
    public ManageTagVO queryManageTagByTagId(Integer tagId) {
        return null;
    }

    @Transactional
    @Override
    public void addManageTag(ManageTagAddDTO manageTagAddDTO) {

    }

    @Transactional
    @Override
    public void editManageTag(ManageTagEditDTO manageTagEditDTO) {

    }

    @Transactional
    @Override
    public void deleteManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {

    }

    @Transactional
    @Override
    public void enableManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {

    }

    @Transactional
    @Override
    public void disableManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {

    }
}
