package com.devsuperior.dslist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class WebConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().addServersItem(new Server().url("https://intensivao-devsuperior-2025-production.up.railway.app"));
	}
}
