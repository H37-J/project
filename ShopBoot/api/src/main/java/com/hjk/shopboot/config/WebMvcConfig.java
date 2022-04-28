package com.hjk.shopboot.config;

import com.hjk.shopboot.intercepter.OrderIntercepter;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


  @Autowired private OrderIntercepter orderIntercepter;

  private static final String CLASSPATH_RESOURCE_LOCATIONS="classpath:/static/";
  private static final Integer YEARS = 31536000;

  //정적자원 캐싱
  @Override
  public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry){
       registry.addResourceHandler("/shop/assets/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS+"shop/assets/").setCachePeriod(YEARS);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry){
      registry.addInterceptor(orderIntercepter).addPathPatterns("/**").excludePathPatterns("api/**","/shop/**","/error","/**/*.img","/**/*.css","/**/*.js","/**/*.png","/**/*.jpg");
  }




}