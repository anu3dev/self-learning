package com.anu3dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception {
		http.csrf(customizer->customizer.disable());
		http.authorizeHttpRequests(authorizeHttp->authorizeHttp.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement
		(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
    
    @SuppressWarnings("deprecation")
	@Bean
	UserDetailsService userDetails() {
    	
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("seema")
				.password("seema")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("golu")
				.password("golu")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
}
