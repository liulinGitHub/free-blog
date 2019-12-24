package com.blog.core.tag.controller;

import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.tag.service.ManageTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ManageTagController
 * @description:
 * @author: liulin
 * @create: 2019-12-16 15:17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/tag")
public class ManageTagController extends BaseController {

    @Autowired
    private ManageTagService manageTagService;

    @PostMapping("/all")
    public ResponseBo queryManageTagByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageTagService.queryManageTagByPage()));
    }
}
