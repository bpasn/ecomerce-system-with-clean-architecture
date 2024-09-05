package com.app.infrastructure.config;


import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(title="E-commerce API",version="1.0",description="API documentation for E-commerce system")

)
public class SwaggerConfig {
    
    // @Bean
    // public OpenAPI openAPI() {
    //     return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info().title("E-commerce API").version("1.0").description("API documentation for E-commerce system"));
    // }
}
