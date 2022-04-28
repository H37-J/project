package com.hjk.shopboot.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.hjk.shopboot.handler.CustomAccessDeniedHandler;
import com.hjk.shopboot.handler.CustomAuthenEntryPoint;
import com.hjk.shopboot.handler.CustomLoginFailureHandler;
import com.hjk.shopboot.handler.CustomLoginSuccessHandler;
import com.hjk.shopboot.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomAuthenEntryPoint customAuthenEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/checkout**", "/user/**", "/user**")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN").antMatchers("/admin**", "/admin/**")
                .hasAnyAuthority("ROLE_ADMIN") // 관리자만
                .anyRequest().permitAll().and().exceptionHandling().authenticationEntryPoint(customAuthenEntryPoint) //변경후 캐시를 지워야 잘 된다
                .accessDeniedHandler(customAccessDeniedHandler).and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login") // th:action
                .successHandler(successHandler()) // 로그인 성공시
                .failureHandler(failureHandler()) // 로그인 실패시
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/test").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true).and().csrf()
                .ignoringAntMatchers("/swagger-ui.html**").and().headers().frameOptions().disable().and()
                .sessionManagement().maximumSessions(1).expiredUrl("/duplicated-login")
                .sessionRegistry(sessionRegistry());

        // http.rememberMe().key("remember-me").userDetailsService(customUserDetailsService)
        //         .tokenRepository(getJDBCRepository()).tokenValiditySeconds(60 * 60 * 24);

        http.csrf().disable();
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    // URL 더블 슬래쉬 허용
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }

    // 실제 인증을 진행할 Provider
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler("/");
    }

    @Bean
    public AuthenticationFailureHandler failureHandler() {
        return new CustomLoginFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    private PersistentTokenRepository getJDBCRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    // @Bean
    // public TokenStore tokenStore() {
    // return new JdbcTokenStore(dataSource);
    // }

    // @Bean
    // public CorsConfigurationSource corsconfigurationSource() {
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.addAllowedOrigin("*");
    // corsConfiguration.addAllowedHeader("*");
    // corsConfiguration.addAllowedMethod("*");
    // corsConfiguration.setAllowCredentials(true);
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", corsConfiguration);
    // return source;
    // }

}
