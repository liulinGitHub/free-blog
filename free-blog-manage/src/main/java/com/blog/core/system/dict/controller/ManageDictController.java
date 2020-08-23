package com.blog.core.system.dict.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.dict.dto.ManageDictAddDTO;
import com.blog.core.system.dict.dto.ManageDictEditDTO;
import com.blog.core.system.dict.service.ManageDictDataService;
import com.blog.core.system.dict.service.ManageDictService;
import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 数据字典信息服务Controller
 * @date: 2020/8/23 16:39
 * @author: 950103
 * @version: 1.0
 */
@Api(value = "数据字典信息服务Controller",tags = "数据字典信息服务")
@RestController
@RequestMapping("/dict")
public class ManageDictController extends BaseController {

    @Autowired
    private ManageDictService manageDictService;

    @Autowired
    private ManageDictDataService manageDictDataService;

    @LogManage("分页查询数据字典信息")
    @ApiOperation(value="分页查询数据字典信息", notes="")
    @GetMapping("/list")
    public ResponseBo queryManageDictByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageDictService.queryManageDictByPage()));
    }

    @LogManage("查看数据字典详细信息")
    @ApiOperation(value="查看数据字典详细信息", notes="")
    @GetMapping("/details/{dictId}")
    public ResponseBo queryManageDictDetails(@PathVariable("dictId") String dictId) {
        return ResponseBo.newDataResponse(this.manageDictService.queryManageDictByDictId(dictId));
    }

    @LogManage("添加数据字典信息")
    @ApiOperation(value="添加数据字典信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageDict(@RequestBody ManageDictAddDTO manageDictAddDTO) {
        this.manageDictService.addManageDict(manageDictAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改数据字典信息")
    @ApiOperation(value="修改数据字典信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editManageDict(@RequestBody ManageDictEditDTO manageDictEditDTO) {
        this.manageDictService.editManageDict(manageDictEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("删除数据字典信息")
    @ApiOperation(value="删除数据字典信息", notes="")
    @DeleteMapping("/delete/{dictId}")
    public ResponseBo deleteManageDict(@PathVariable("dictId") String dictId) {
        this.manageDictService.deleteManageDict(dictId);
        return ResponseBo.ok();
    }


    @LogManage("查询数据字典数据详情信息")
    @ApiOperation(value="查询数据字典数据详情信息", notes="")
    @GetMapping("/data/details/{dictId}")
    public ResponseBo queryManageDictDataDetails(@PathVariable("dictId") String dictId) {
        return ResponseBo.newDataResponse(this.manageDictDataService.queryManageDictDataDetails(dictId));
    }

    @LogManage("根据字段名称查询数据字典数据详情信息")
    @ApiOperation(value="根据字段名称查询数据字典数据详情信息", notes="")
    @GetMapping("/data/fieldType")
    public ResponseBo queryManageDictDataByFieldType(@RequestParam("fieldType") String fieldType) {
        return ResponseBo.newDataResponse(this.manageDictDataService.queryManageDictDataByFieldType(fieldType));
    }

    @LogManage("删除数据字典数据信息")
    @ApiOperation(value="删除数据字典信息", notes="")
    @DeleteMapping("/data/delete/{dictDataId}")
    public ResponseBo deleteManageDictData(@PathVariable("dictDataId") String dictDataId) {
        this.manageDictDataService.deleteManageDictData(dictDataId);
        return ResponseBo.ok();
    }
}
