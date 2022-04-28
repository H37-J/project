// package com.hjk.shopboot.oauth2;

// import com.hjk.shopboot.service.CustomUserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
// import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
// import org.springframework.security.oauth2.provider.token.TokenStore;
// import org.springframework.web.bind.annotation.CrossOrigin;

// @EnableAuthorizationServer
// @Configuration
// @CrossOrigin("*")
// public class OauthConfig extends AuthorizationServerConfigurerAdapter {

//     @Autowired
//     private TokenStore tokenStore;

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @Autowired
//     private CustomUserService oauthService;

//     @Override
//     public void configure(ClientDetailsServiceConfigurer client) throws Exception{
//         client.inMemory()
//                 .withClient("test")
//                 .secret(passwordEncoder.encode("testSecret"))
//                 .authorizedGrantTypes("authorization_code","password","refresh_token")
//                 .scopes("read","write")
//                 .accessTokenValiditySeconds(60*60*60)
//                 .refreshTokenValiditySeconds(6*60*60*60)
//                 .autoApprove(true);

//                 //Basic Auth(test,testSecret)
//     }

//     @Override public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//         endpoints.tokenStore(tokenStore)
//                 .authenticationManager(authenticationManager)
//                 .userDetailsService(oauthService);
//     }



// }
