package com.blog.core.tag.entity.qo;

import lombok.Data;

import java.util.List;

/**
 * @program: ManageTagDeleteQO
 * @description: 标签删除
 * @author: liulin
 * @create: 2019-07-25 11:16
 * @Version: 1.0
 */
@Data
public class ManageTagDeleteDTO {

    private List<String> tagIdList;
}
