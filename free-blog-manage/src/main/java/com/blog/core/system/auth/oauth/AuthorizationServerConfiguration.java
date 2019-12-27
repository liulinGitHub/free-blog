package com.blog.core.system.auth.oauth;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @program: AuthorizationServerConfiguration
 * @description: 认证服务器
 * @author: liulin
 * @create: 2019-12-27 12:04
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("app")
                .authorizedGrantTypes()
                .scopes("server")
                .redirectUris();
    }
}
