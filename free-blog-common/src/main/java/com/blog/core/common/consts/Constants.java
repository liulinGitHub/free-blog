package com.blog.core.common.consts;

import com.blog.core.common.enums.ApprovalTypeEnum;

/**
 * @program: CommonConst
 * @description: 常用常量
 * @author: liulin
 * @create: 2019-06-29 11:26
 * @Version: 1.0
 */
public interface Constants {

    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    static String getApprovalKey(ApprovalTypeEnum approvalType, Object subjectId) {
        return approvalType + ":" + subjectId;
    }

    static String getReportKey(ApprovalTypeEnum approvalType) {
        ApprovalTypeEnum type = null;
        switch (approvalType) {
            case APPROVAL_ARTICLE:
                type = ApprovalTypeEnum.LIKED_ARTICLE_REPORT;
        }
        return type + "";
    }

    /**
     * 用于IP定位转换
     */
    String REGION = "内网IP|内网IP";

    /**
     * 主键警告值
     */
    Integer PRIMARY_WARN_VALUE = 10;

}
