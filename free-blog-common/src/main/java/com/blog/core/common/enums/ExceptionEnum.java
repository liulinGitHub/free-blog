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

/**
 * @program: free-blog
 * @description: 异常信息枚举
 * @author: liulin
 * @create: 2019-05-04 17:34
 */

public enum ExceptionEnum {

    AUTHORIZATION_ERROR(401, "请先登录"),
    TOKEN_NONE(301, "token无效！"),
    DATA_NOT_FOUND(404, "数据未找到"),
    PARAMETER_ILLEGAL(403, "参数无效"),
    USER_NOT_FOUND(602, "用户不存在"),
    USERNAME_PASSWORD_ERROR(601, "用户名或密码错误"),
    ARTICLE_THUMBUP_ERROR(603, "已经点过赞")
    ;

    private int code;

    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
