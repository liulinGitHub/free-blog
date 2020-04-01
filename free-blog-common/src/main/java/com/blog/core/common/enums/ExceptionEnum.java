/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blog.core.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @program: free-blog
 * @description: 异常信息枚举
 * @author: liulin
 * @create: 2019-05-04 17:34
 */

public enum ExceptionEnum implements BaseEnum {

    AUTHORIZATION_ERROR("401", "权限不足，请先配置权限"),
    TOKEN_NONE("301", "token无效！"),
    DATA_NOT_FOUND("404", "数据未找到"),
    PARAMETER_ILLEGAL("403", "参数无效"),
    USER_NOT_FOUND("602", "用户不存在"),
    USERNAME_PASSWORD_ERROR("601", "用户名或密码错误"),
    ARTICLE_THUMBUP_ERROR("603", "已经点过赞")
    ;

    private String value;

    private String name;

    ExceptionEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @JsonCreator
    @Override
    public String toString() {
        return value;
    }

    public String getName() {
        return name;
    }

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }

}
