package com.blog.core.tag.service.impl;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.PrimarykeyUtil;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.tag.dao.ManageTagMapper;
import com.blog.core.tag.dto.ManageTagAddDTO;
import com.blog.core.tag.dto.ManageTagEditDTO;
import com.blog.core.tag.dto.ManageTagIdDTO;
import com.blog.core.tag.entity.ManageTag;
import com.blog.core.tag.service.ManageTagService;
import com.blog.core.tag.vo.ManageTagListVO;
import com.blog.core.tag.vo.ManageTagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2019-12-16 15:18
 * @Version: 1.0
 */
@Service
public class ManageTagServiceImpl implements ManageTagService {

    @Autowired
    private ManageTagMapper manageTagMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Override
    public List<ManageTagListVO> queryManageTagByPage() {
        List<ManageTagListVO> manageTagListVOList = this.manageTagMapper.selectManageTagByPage();
        return manageTagListVOList;
    }

    @Override
    public ManageTagVO queryManageTagByTagId(String tagId) {
        ManageTagVO manageTagVO = this.manageTagMapper.selectManageTagByTagId(tagId);
        return manageTagVO;
    }

    @Transactional
    @Override
    public void addManageTag(ManageTagAddDTO manageTagAddDTO) {
        SecurityUser user = SecurityUtils.getUser();
        ManageTag manageTag = MapperUtils.mapperBean(manageTagAddDTO, ManageTag.class);
        manageTag.setTagId(primarykeyUtil.getPimaryKey());
        manageTag.setCreateId(user.getUserId());
        manageTag.setCreateTime(new Date());
        manageTag.setEnable(EnableEnum.Enable_YES);
        this.manageTagMapper.insertManageTag(manageTag);
    }

    @Transactional
    @Override
    public void editManageTag(ManageTagEditDTO manageTagEditDTO) {
        SecurityUser user = SecurityUtils.getUser();
        ManageTag manageTag = MapperUtils.mapperBean(manageTagEditDTO, ManageTag.class);
        manageTag.setUpdateId(user.getUserId());
        manageTag.setUpdateTime(new Date());
        this.manageTagMapper.updateManageTag(manageTag);
    }

    @Transactional
    @Override
    public void deleteManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {
        this.manageTagMapper.deleteManageTagByTagId(manageTagIdDTO.getTagIdList());
    }

    @Transactional
    @Override
    public void enableManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {
        this.manageTagMapper.updateEnableManageTagByTagId(manageTagIdDTO.getTagIdList());
    }

    @Transactional
    @Override
    public void disableManageTagByTagId(ManageTagIdDTO manageTagIdDTO) {
        this.manageTagMapper.updateDisableManageTagByTagId(manageTagIdDTO.getTagIdList());
    }

    @Transactional
    @Override
    public void parent(){
        ManageTag manageTag = new ManageTag();
        manageTag.setTagId("123");
        manageTag.setTagName("测试一");
        this.manageTagMapper.add(manageTag);
    }

    @Transactional
    @Override
    public void child(){
        ManageTag manageTag = new ManageTag();
        manageTag.setTagId("124");
        manageTag.setTagName("测试二");
        this.manageTagMapper.add(manageTag);
    }
}
