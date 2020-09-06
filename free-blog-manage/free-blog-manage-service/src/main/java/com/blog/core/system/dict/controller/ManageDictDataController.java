package com.blog.core.system.dict.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.dict.service.ManageDictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 数据字典数据服务Controller
 * @author: 950103
 * @create_time: 2020/9/5 19:38
 * @version 1.0
 */
@Api(value = "数据字典数据服务Controller",tags = "数据字典数据服务Controller")
@RestController
@RequestMapping("/dict/data")
public class ManageDictDataController {

    @Autowired
    private ManageDictDataService manageDictDataService;

    @LogManage("查询数据字典数据详情信息")
    @ApiOperation(value="查询数据字典数据详情信息", notes="")
    @GetMapping("/details/{dictId}")
    public ResponseBo queryManageDictDataDetails(@PathVariable("dictId") String dictId) {
        return ResponseBo.newDataResponse(this.manageDictDataService.queryManageDictDataDetails(dictId));
    }

    @LogManage("根据字段名称查询数据字典数据详情信息")
    @ApiOperation(value="根据字段名称查询数据字典数据详情信息", notes="")
    @GetMapping("/fieldType")
    public ResponseBo queryManageDictDataByFieldType(@RequestParam("fieldType") String fieldType) {
        return ResponseBo.newDataResponse(this.manageDictDataService.queryManageDictDataByFieldType(fieldType));
    }

    @LogManage("删除数据字典数据信息")
    @ApiOperation(value="删除数据字典信息", notes="")
    @DeleteMapping("/delete/{dictDataId}")
    public ResponseBo deleteManageDictData(@PathVariable("dictDataId") String dictDataId) {
        this.manageDictDataService.deleteManageDictData(dictDataId);
        return ResponseBo.ok();
    }
}
