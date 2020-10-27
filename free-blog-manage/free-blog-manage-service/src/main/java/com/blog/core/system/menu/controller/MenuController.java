package com.blog.core.system.menu.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.menu.dto.MenuAddDTO;
import com.blog.core.system.menu.dto.MenuEditDTO;
import com.blog.core.system.menu.service.MenuService;
import com.blog.core.system.menu.vo.MenuListVO;
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
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("获取前端所需菜单")
    @GetMapping(value = "/nav")
    public ResponseBo buildMenus() {
        return ResponseBo.newDataResponse(menuService.buildMenus());
    }

    @LogManage("分页查询菜单信息")
    @ApiOperation(value="分页查询菜单信息", notes="")
    @GetMapping("/queryPage")
    public ResponseBo queryMenuByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> menuService.queryMenuAll()));
    }

    @LogManage("查看菜单信息详情")
    @ApiOperation(value="查看菜单信息详情", notes="")
    @GetMapping("/details/{menuId}")
    public ResponseBo queryMenuDetails(@PathVariable("menuId") Integer menuId) {
        return ResponseBo.newDataResponse(this.menuService.queryMenuByMenuId(menuId));
    }

    @LogManage("添加菜单信息")
    @ApiOperation(value="添加菜单信息", notes="")
    @PostMapping("/add")
    public ResponseBo addMenu(@RequestBody @Valid MenuAddDTO menuAddDTO) {
        this.menuService.addMenu(menuAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改菜单信息")
    @ApiOperation(value="修改菜单信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editMenu(@RequestBody @Valid MenuEditDTO menuEditDTO) {
        this.menuService.editMenu(menuEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("禁用菜单信息")
    @ApiOperation(value="禁用菜单信息", notes="")
    @GetMapping("/disable/{menuId}")
    public ResponseBo disableMenu(@PathVariable("menuId") Integer menuId) {
        this.menuService.disableMenu(menuId);
        return ResponseBo.ok();
    }

    @LogManage("启用菜单信息")
    @ApiOperation(value="启用菜单信息", notes="")
    @GetMapping("/enable/{menuId}")
    public ResponseBo enableMenu(@PathVariable("menuId") Integer menuId) {
        this.menuService.enableMenu(menuId);
        return ResponseBo.ok();
    }
}
