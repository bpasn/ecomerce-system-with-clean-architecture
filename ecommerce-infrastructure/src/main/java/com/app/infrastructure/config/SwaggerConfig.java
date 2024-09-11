package com.app.infrastructure.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
    return new OpenAPI()
            .info(
                    new Info().title("Ecommerce manager")
                    .description("This is ecommerce service")
                            .version("v0.0.1")
                            .license(new License().name("Apache 2.0").url("http://springdoc.org"))
            ).externalDocs(new ExternalDocumentation().description("SpringBoot Wiki Documentation").url("https://springboot.wiki.github.org/docs"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(
                    new Components().addSecuritySchemes("bearerAuth",
                            new SecurityScheme().name("bearerAuth")
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT"))
            );
}

//@Bean
//    public OpenApiCustomizer customizer(){
//        return openApi -> openApi.getComponents().getSchemas().clear();
//}
}
