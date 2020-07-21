package com.man.sale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableCaching
@EnableWebSecurity
public class SaleserviceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SaleserviceApplication.class);

	public static void main(String[] args) {
		logger.info("This is info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
		
		SpringApplication.run(SaleserviceApplication.class, args);
	}

	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/sale/*"))
				.apis(RequestHandlerSelectors.basePackage("com.man"))
				.build();
				
		
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	
	
}
