package com.mudigal.talentmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***********************************
 *
 * @author Vijayendra Mudigal
 * @contact vijayendrap@gmail.com
 *
 **********************************/

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.mudigal.talentmanagement" })
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().tags(new Tag("Candidate Onboarding", "register/list candidates", 1)).apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Talent Management Platform")
				.description("API documentation for Talent Management Platform.").termsOfServiceUrl("#")
				.contact(new Contact("Contact", "https://vijayendra.mudigal.com/", "vijayendrap@gmail.com"))
				.license("Apache License 2.0").licenseUrl("").version("1.0").build();
	}

}