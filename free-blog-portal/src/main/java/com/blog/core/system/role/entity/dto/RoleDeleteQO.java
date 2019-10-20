package com.blog.core.system.role.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: RoleDeleteQO
 * @description:
 * @author: liulin
 * @create: 2019-07-18 17:06
 * @Version: 1.0
 */
@Data
public class RoleDeleteQO {

    private List<String> roleIdList;
}
