package com.blog.core.system.user.service.impl;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.system.role.entity.vo.PortalRoleVO;
import com.blog.core.system.role.service.PortalRoleService;
import com.blog.core.system.user.dao.PortalUserMapper;
import com.blog.core.system.user.entity.domain.PortalUser;
import com.blog.core.system.user.entity.dto.PortalUserAddDTO;
import com.blog.core.system.user.entity.dto.PortalUserEditDTO;
import com.blog.core.system.user.entity.dto.PortalUserLoginDTO;
import com.blog.core.system.user.entity.dto.PortalUserQueryDTO;
import com.blog.core.system.user.entity.vo.PortalUserInfoVO;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import com.blog.core.system.user.entity.vo.PortalUserVO;
import com.blog.core.common.enums.IsEnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.system.user.service.PortalUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassNmae:UserServiceImpl
 * @description:
 * @Author:liulin
 * @Date: 2019/4/6 15:25
 **/

@Service("portalUserService")
public class PortalUserServiceImpl implements PortalUserService {

    @Resource
    private PortalUserMapper portalUserMapper;

    @Resource
    private PortalRoleService portalRoleService;

    @Override
    public PortalUserLoginVO login(PortalUserLoginDTO portalUserLoginDTO){
        PortalUser portalUser = MapperUtils.mapperBean(portalUserLoginDTO, PortalUser.class);
        portalUser.getUserPassword();
        PortalUserLoginVO userLogin = this.portalUserMapper.login(portalUserLoginDTO);
        return userLogin;
    }

    @Override
    public PortalUserLoginVO checkLogin(PortalUserLoginDTO portalUserLoginDTO){
        PortalUserLoginVO portalUserLoginVO = this.portalUserMapper.selectUserByUserName(portalUserLoginDTO.getUsername());
        if(Objects.isNull(portalUserLoginVO)){
            throw new BlogRuntimeException("用户名不存在");
        }else {
//           // String as = new Sha256Hash(userLoginVO.getUserPassword(),userLoginVO.getSalt()).toHex();
//            System.out.println(as);
//            System.out.println(userLoginVO.getUserPassword());
//            if(!userLoginVO.getUserPassword().equals(new Sha256Hash(userLoginDTO.getUserpassword(),userLoginVO.getSalt()).toHex())){
//                throw new BlogRuntimeException("密码错误！");
//            }
        }
        return portalUserLoginVO;
    }

    /**
     * 根据用户名查询用户信息
     * @param username
     */
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
    public List<PortalUserVO> queryUser(PortalUserQueryDTO portalUserQueryDTO){
        List<PortalUserVO> portalUserVOList = this.portalUserMapper.queryUser(portalUserQueryDTO);
        return portalUserVOList;
    }

    @Override
    public PortalUserVO queryUserById(String userId){
        PortalUserVO portalUserVO = this.portalUserMapper.selectUserById(userId);
        return portalUserVO;
    }

    @Transactional
    @Override
    public void addUser(PortalUserAddDTO portalUserAddDTO){
        PortalUser portalUser = MapperUtils.mapperBean(portalUserAddDTO, PortalUser.class);
        portalUser.setId(UUIDUtil.randomUUID32());
        portalUser.setCreateId(RequestHolder.get()+"");
        portalUser.setCreateTime(new Date());
        portalUser.setIsEnable(IsEnableEnum.Enable_NO.getValue());
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
    public void updateUser(PortalUserEditDTO portalUserEditDTO){
        PortalUser portalUser = MapperUtils.mapperBean(portalUserEditDTO, PortalUser.class);
        portalUser.setUpdateTime(new Date());
        int result = this.portalUserMapper.updateUser(portalUser);
        if(result < 1){
            throw new BlogRuntimeException("修改用户信息失败！");
        }
    }

}
