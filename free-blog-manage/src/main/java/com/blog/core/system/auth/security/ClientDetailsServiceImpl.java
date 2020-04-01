//package com.blog.core.system.auth.security;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.ClientRegistrationException;
//import org.springframework.security.oauth2.provider.NoSuchClientException;
//import org.springframework.security.oauth2.provider.client.BaseClientDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author: yaohw
// * @create: 2019-10-12 16:12
// **/
//@Service
//@Log4j2
//    public class ClientDetailsServiceImpl implements ClientDetailsService {
//
//    /**
//     * Load a client by the client id. This method must not return null.
//     *
//     * @param clientId The client id.
//     * @return The client details (never null).
//     * @throws ClientRegistrationException If the client account is locked, expired, disabled, or invalid for any other reason.
//     */
//    @Override
//    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
//        log.info("客户端查询:"+clientId);
//        BaseClientDetails clientDetails = new BaseClientDetails();
//        clientDetails.setAuthorities(new ArrayList<>());
//        clientDetails.setClientId("freeBlog");
//        //这个客户端秘钥和密码一样存BCryptPasswordEncoder加密后的接口，具体看定义的加密器
//        clientDetails.setClientSecret("$2a$10$CwIutywnbs9bifHaY3Ezu.gYkWi4Zano8gVPq08hXjal6.uj.Yzuy");
//        //设置accessToken和refreshToken的时效，如果不设置则使tokenServices的配置的
//        clientDetails.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2));
//        clientDetails.setRefreshTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(30));
//        List<String> scopes = new ArrayList<>(1);
//        scopes.add("sever");
//        clientDetails.setScope(scopes);
//        List<String> grantTypes = new ArrayList<>(2);
//        grantTypes.add("password");
//        grantTypes.add("refresh_token");
//        grantTypes.add("authorization_code");
//        grantTypes.add("implicit");
//        grantTypes.add("mobile");
//        clientDetails.setAuthorizedGrantTypes(grantTypes);
//        Set<String> sets = new HashSet<>(1);
//        sets.add("http://www.baidu.com");
//        clientDetails.setRegisteredRedirectUri(sets);
//        List<String> autoApproveScopes = new ArrayList<>(1);
//        autoApproveScopes.add("sever");
//        //自动批准作用于，授权码模式时使用，登录验证后直接返回code，不再需要下一步点击授权
//        clientDetails.setAutoApproveScopes(autoApproveScopes);
//        if (clientDetails == null) {
//            throw new NoSuchClientException("not found clientId:" + clientId);
//        }
//        return clientDetails;
//    }
//}
