package com.erivas.embd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class TrailersDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrailersDbApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// Return a Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.erivas.embd"))
				.build()
				.apiInfo(getApiDetails());
	}

	private ApiInfo getApiDetails() {
		return new ApiInfo(
				"EMBD Movies REST API",
				"Subject: Programming II",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Esteban Rivas", "github.com/estebanarivasv", "estebanarivasv@gmail.com"),
				"API License",
				"",
				Collections.emptyList()
		);
	}
}
