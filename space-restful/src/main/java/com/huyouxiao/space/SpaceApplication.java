package com.huyouxiao.space;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@ComponentScan(basePackages = "com.huyouxiao.space")
@MapperScan(value = "com.huyouxiao.space")
@SpringBootApplication
@EnableWebMvc
public class SpaceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpaceApplication.class, args);
  }
}
