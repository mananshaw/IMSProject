package com.man.pro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProductionserviceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductionserviceApplication.class);

	public static void main(String[] args) {
		
		
		logger.error("inside ProductionserviceApplication");
		
		SpringApplication.run(ProductionserviceApplication.class, args);
	}
	
	
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/production/*"))
				.apis(RequestHandlerSelectors.basePackage("com.man"))
				.build();
				
		
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
