package com.devsuperior.dslist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class WebConfig {
	
	/*
	 * @Value("${cors.origins}") private String corsOrigins;
	 * 
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins(corsOrigins) .allowedMethods("*")
	 * .allowedHeaders("*") .allowCredentials(true); } }; }
	 */
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().addServersItem(new Server().url("https://intensivao-devsuperior-2025-production.up.railway.app/"));
	}
}
