package com.devsuperior.dslist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI configuracao() {
        return new OpenAPI()
                .info(new Info()
                        .title("API DE GAMES")
                        .description("API GAMES INSTENSIVÃO DEVSUPERIOR")
                        .version("1.0.0")
                );
    }

}
