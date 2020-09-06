package com.blog.core.system.menu.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.menu.dto.ManageMenuAddDTO;
import com.blog.core.system.menu.dto.ManageMenuEditDTO;
import com.blog.core.system.menu.service.ManageMenuService;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 菜单管理
 * @author: 950103
 * @create_time: 2019/12/8 22:53
 * @version: 1.0
 **/
@Api(value = "菜单管理服务Controller",tags = "菜单管理服务")
@RestController
@RequestMapping("/api/menu")
public class ManageMenuController extends BaseController {

    @Autowired
    private ManageMenuService manageMenuService;

    @ApiOperation("获取前端所需菜单")
    @GetMapping(value = "/build")
    public ResponseBo buildMenus(){
        List<ManageMenuListVO> manageMenuListVOS = this.manageMenuService.queryBuildManageMenu();
        List<ManageMenuListVO> manageMenuListVOList = this.manageMenuService.buildMenuTree(manageMenuListVOS);
        return ResponseBo.newDataResponse(manageMenuService.buildMenus(manageMenuListVOList));
    }

    @LogManage("分页查询菜单信息")
    @ApiOperation(value="分页查询菜单信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryManageMenuByPage(QueryRequest queryRequest){
        List<ManageMenuListVO> manageMenuListVOS = this.manageMenuService.queryManageMenuAll();
        List<ManageMenuListVO> manageMenuListVOList = this.manageMenuService.buildMenuTree(manageMenuListVOS);
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () ->
                manageMenuListVOList));
    }

    @LogManage("查看菜单信息详情")
    @ApiOperation(value="查看菜单信息详情", notes="")
    @GetMapping("/details/{menuId}")
    public ResponseBo queryManageMenuDetails(@PathVariable("menuId") Integer menuId){
        return ResponseBo.newDataResponse(this.manageMenuService.queryManageMenuByMenuId(menuId));
    }

    @LogManage("添加菜单信息")
    @ApiOperation(value="添加菜单信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageMenu(@RequestBody @Valid ManageMenuAddDTO manageMenuAddDTO){
        this.manageMenuService.addManageMenu(manageMenuAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改菜单信息")
    @ApiOperation(value="修改菜单信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editManageMenu(@RequestBody @Valid ManageMenuEditDTO manageMenuEditDTO){
        this.manageMenuService.editManageMenu(manageMenuEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("禁用菜单信息")
    @ApiOperation(value="禁用菜单信息", notes="")
    @GetMapping("/disable/{menuId}")
    public ResponseBo disableManageMenu(@PathVariable("menuId") Integer menuId){
        this.manageMenuService.disableManageMenu(menuId);
        return ResponseBo.ok();
    }

    @LogManage("启用菜单信息")
    @ApiOperation(value="启用菜单信息", notes="")
    @GetMapping("/enable/{menuId}")
    public ResponseBo enableManageMenu(@PathVariable("menuId") Integer menuId){
        this.manageMenuService.enableManageMenu(menuId);
        return ResponseBo.ok();
    }
}
