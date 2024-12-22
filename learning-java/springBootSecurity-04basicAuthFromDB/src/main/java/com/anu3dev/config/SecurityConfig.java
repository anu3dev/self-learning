package com.anu3dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception {
		http.csrf(customizer->customizer.disable());
		http.authorizeHttpRequests(authorizeHttp -> authorizeHttp
				// Allow access to /add-user-without-pass without authentication
				.requestMatchers("/public-api/**", "/add-user-without-pass").permitAll()
				// All other requests require authentication
				.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement
		(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	
	@Bean
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailsService);
		daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoProvider;
	}
}
