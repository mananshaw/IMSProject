package com.manan.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication

@EnableCaching

@EnableWebSecurity

//@EnableJpaRepositories("com.manan.springcloud.repo")
//@EntityScan("com.manan.springcloud.entity")
public class PurchaseserviceApplication {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseserviceApplication.class);

	public static void main(String[] args) {

		logger.info("Inside PurchaseserviceApplication");

		SpringApplication.run(PurchaseserviceApplication.class, args);

		logger.error("Inside PurchaseserviceApplication");
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/purchase/*"))
				.apis(RequestHandlerSelectors.basePackage("com.manan")).build();

	}

}
