package com.univ.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()

        // equivalent::  .apis(RequestHandlerSelectors.any())
        .apis(RequestHandlerSelectors.basePackage("com.univ.cinema.controller"))

        // equivalent::  .paths(PathSelectors.any())
        .paths(PathSelectors.ant("/cinema/**"))

        .build();
  }
}