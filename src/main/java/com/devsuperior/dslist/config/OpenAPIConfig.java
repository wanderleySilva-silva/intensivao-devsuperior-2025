package com.devsuperior.dslist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI configuracao() {
        return new OpenAPI()
                .info(new Info()
                        .title("API DE GAMES")
                        .description("API GAMES INSTENSIVÃO DEVSUPERIOR")
                        .version("1.0.0"))
                .addServersItem(new Server().url("https://intensivao-devsuperior-2025-production.up.railway.app"));
    }

}
