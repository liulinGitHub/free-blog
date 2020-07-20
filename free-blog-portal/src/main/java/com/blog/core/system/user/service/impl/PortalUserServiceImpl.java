package com.blog.core.system.user.service.impl;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.system.role.service.PortalRoleService;
import com.blog.core.system.role.vo.PortalRoleVO;
import com.blog.core.system.user.dao.PortalUserMapper;
import com.blog.core.system.user.dto.PortalUserAddDTO;
import com.blog.core.system.user.dto.PortalUserEditDTO;
import com.blog.core.system.user.dto.PortalUserQueryDTO;
import com.blog.core.system.user.entity.PortalUser;
import com.blog.core.system.user.vo.PortalUserInfoVO;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.system.user.service.PortalUserService;
import com.blog.core.system.user.vo.PortalUserVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: PortalUserServiceImpl
 * @Description: 用户service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
@Service("portalUserService")
public class PortalUserServiceImpl implements PortalUserService {

    @Resource
    private PortalUserMapper portalUserMapper;

    @Resource
    private PortalRoleService portalRoleService;

    @Override
    public PortalUserLoginVO queryUserByUserName(String username){
        PortalUserLoginVO portalUserLoginVO = this.portalUserMapper.selectUserByUserName(username);
        return portalUserLoginVO;
    }


    @Override
    public PortalUserInfoVO queryUserInfo(String userId) {
        PortalUserInfoVO portalUserInfoVO = this.portalUserMapper.selectUserInfo(userId);
        if(Objects.nonNull(portalUserInfoVO)){
            List<PortalRoleVO> roleVOList = this.portalRoleService.queryRoleByUserId(portalUserInfoVO.getUserId());
            if(CollectionUtils.isNotEmpty(roleVOList)){
                portalUserInfoVO.setRoleVOList(roleVOList);
            }
        }
        return portalUserInfoVO;
    }

    @Override
    public List<PortalUserVO> queryPortalUser(PortalUserQueryDTO portalUserQueryDTO){
        List<PortalUserVO> portalUserVOList = this.portalUserMapper.queryUser(portalUserQueryDTO);
        return portalUserVOList;
    }

    @Override
    public PortalUserVO queryPortalUserDetails(String userId){
        return this.portalUserMapper.selectUserById(userId);
    }

    @Transactional
    @Override
    public void savePortalUser(PortalUserAddDTO portalUserAddDTO){
        PortalUser portalUser = MapperUtils.mapperBean(portalUserAddDTO, PortalUser.class);
        portalUser.setUserId(UUIDUtil.randomUUID32());
        portalUser.setCreateId(RequestHolder.get()+"");
        portalUser.setCreateTime(new Date());
        portalUser.setEnable(EnableEnum.Enable_NO.getValue());
//        User.setCreateName("");
        //sha256加密
        //String salt = RandomStringUtils.randomAlphanumeric(20);
        //user.setSalt(salt);
        // user.setUserPassword(new Sha256Hash(user.getUserPassword(), salt).toHex());
        int result = this.portalUserMapper.insertUser(portalUser);
        if(result < 1){
            throw new BlogRuntimeException("添加用户信息失败！");
        }
    }

    @Transactional
    @Override
    public void editPortalUser(PortalUserEditDTO portalUserEditDTO){
        PortalUser portalUser = MapperUtils.mapperBean(portalUserEditDTO, PortalUser.class);
        portalUser.setUpdateTime(new Date());
        this.portalUserMapper.updateUser(portalUser);
    }

}
