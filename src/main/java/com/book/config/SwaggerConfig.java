package com.book.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI bookPriceOpenAPI() {
		return new OpenAPI().info(new Info().title("BookPriceApplication")
				.description("API that calculates the total price based on the purchased books and discount")
				.version("1.0"));
	}
}
