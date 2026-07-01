package com.tka.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(auth -> auth

						// Login API
						.requestMatchers("/auth/login").permitAll()

						// Admin APIs
						.requestMatchers("/movie/saveMovie", "/movie/updateMovie/**", "/movie/deleteMovie/**")
						.hasRole("ADMIN")

						// User APIs
						.requestMatchers("/booking/**", "/payment/**").hasAnyRole("USER", "ADMIN")

						.anyRequest().authenticated());

		return http.build();
	}
}
