package com.blog.core.system.auth.oauth;


import com.blog.core.system.user.service.CustomizeUserDetailsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import sun.security.util.SecurityConstants;

/**
 * @program: AuthorizationServerConfiguration
 * @description: 认证服务器
 * @author: liulin
 * @create: 2019-12-27 12:04
 * @Version: 1.0
 */
@Configuration
@Order(3)
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApprovalStore approvalStore;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //内存配置写死
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //添加客户端信息
        //使用内存存储OAuth客户端信息
        clients.inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret("secret")
                // 该client允许的授权类型，不同的类型，则获得token的方式不一样。
                .authorizedGrantTypes("authorization_code","implicit","refresh_token")
                .resourceIds("resourceId")
                //回调uri，在authorization_code与implicit授权方式时，用以接收服务器的返回信息
                .redirectUris("http://localhost:8090/")
                // 允许的授权范围
                .scopes("app","test");
    }
//    数据库模式
//    @Override
//    @SneakyThrows
//    public void configure(ClientDetailsServiceConfigurer clients) {
//        PigClientDetailsService clientDetailsService = new PigClientDetailsService(dataSource);
//        clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
//        clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
//        clients.withClientDetails(clientDetailsService);
//    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).approvalStore(approvalStore)
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.realm("OAuth2-Sample")
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public TokenStore tokenStore() {
        //token保存在内存中（也可以保存在数据库、Redis中）。
        //如果保存在中间件（数据库、Redis），那么资源服务器与认证服务器可以不在同一个工程中。
        //注意：如果不保存access_token，则没法通过access_token取得用户信息
        return new InMemoryTokenStore();
    }

    @Bean
    public ApprovalStore approvalStore() throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }
}
