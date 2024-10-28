package com.sb.swagger;

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
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)  // UI screen type
		          .select()                              // to specify rest controller    
		          .apis(RequestHandlerSelectors.basePackage("com.sb.controller"))  // base package controller            
		          .paths(PathSelectors.regex("/tourist/api.*"))                //     api path     
		          .build(); 
	}
}
