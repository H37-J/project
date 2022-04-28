// package com.hjk.shopboot.oauth2;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
// import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
// import org.springframework.web.bind.annotation.CrossOrigin;

// @Configuration
// @EnableResourceServer
// public class ResourceConfig extends ResourceServerConfigurerAdapter {

//     @Override
//     public void configure(HttpSecurity http) throws Exception{
//         http.anonymous().disable()
//                 .authorizeRequests()
//                 .antMatchers("/api/test/**").authenticated()
//                 .and()
//                 .exceptionHandling()
//                 .accessDeniedHandler(new OAuth2AccessDeniedHandler());

//     }
// }
