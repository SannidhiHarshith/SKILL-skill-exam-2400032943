package com.klef.soa.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Visa Service API")
                        .version("1.0")
                        .description("REST API Documentation for Visa Microservice")
                        .contact(new Contact()
                                .name("AIRLINES")
                                .email("airlines@gmail.com")));
    }

}
