package com.huyouxiao.space;

import com.huyouxiao.space.common.context.FileStorageProperties;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@ComponentScan(basePackages = "com.huyouxiao.space")
@MapperScan(value = "com.huyouxiao.space.dao.mapper")
@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SpaceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpaceApplication.class, args);
  }

  @Bean
  public TomcatServletWebServerFactory tomcatEmbedded() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
      if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
        //-1 means unlimited
        ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
      }
    });
    return tomcat;
  }

  @Bean
  public CorsFilter corsFilter() {
    //1.添加CORS配置信息
    CorsConfiguration config = new CorsConfiguration();
    //放行哪些原始域
    config.addAllowedOrigin("*");
    //是否发送Cookie信息
    config.setAllowCredentials(true);
    //放行哪些原始域(请求方式)
    config.addAllowedMethod("*");
    //放行哪些原始域(头部信息)
    config.addAllowedHeader("*");
    //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
    config.addExposedHeader("cookies");

    //2.添加映射路径
    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);

    //3.返回新的CorsFilter.
    return new CorsFilter(configSource);
  }
}
