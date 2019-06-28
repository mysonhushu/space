package com.huyouxiao.space.web.config;

import com.huyouxiao.space.web.interceptor.AppSessionHandlerInterceptor;
import com.huyouxiao.space.web.interceptor.WebSessionHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {

  @Autowired
  WebSessionHandlerInterceptor webSessionHandlerInterceptor;
  @Autowired
  AppSessionHandlerInterceptor appSessionHandlerInterceptor;

  protected void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration webInterceptorRegistration = registry.addInterceptor(webSessionHandlerInterceptor);
    webInterceptorRegistration.addPathPatterns("/web/**");
    webInterceptorRegistration.excludePathPatterns("/api/**");

    InterceptorRegistration appInterceptorRegistration = registry.addInterceptor(appSessionHandlerInterceptor);
    appInterceptorRegistration.addPathPatterns("/app/**");
    appInterceptorRegistration.excludePathPatterns("/api/**");
  }
}