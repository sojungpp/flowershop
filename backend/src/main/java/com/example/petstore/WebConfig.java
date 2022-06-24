package com.example.petstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//bean등록 위한 annotation
@Configuration
public class WebConfig implements WebMvcConfigurer {
//오버라이딩 행위 재정의 - 매핑&서버
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/flowers")
        .allowedOrigins("http://localhost:8081");
  }
}