package com.anu3dev.main.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	public Config(){
		System.out.println("Config bean is created");
	}
	
	@Bean
	LocalTime createTime(){
		return LocalTime.now();
	}
}
