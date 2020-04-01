package com.blog.core.comment.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.comment.service.ManageCommentService;
import com.blog.core.comment.vo.ManageCommentListVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageCommentServiceImplTest {

    @Autowired
    private ManageCommentService manageCommentService;

    @Test
    public void queryManageCommentByPage() {
        List<ManageCommentListVO> commentListVOS = manageCommentService.queryManageCommentByPage();
        System.out.println(JSONObject.toJSONString(commentListVOS));
    }
}
