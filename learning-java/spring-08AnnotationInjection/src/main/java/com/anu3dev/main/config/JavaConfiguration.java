package com.anu3dev.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.anu3dev.main"})
public class JavaConfiguration {
	public JavaConfiguration() {
		System.out.println("Java Config Bean created");
	}
}
