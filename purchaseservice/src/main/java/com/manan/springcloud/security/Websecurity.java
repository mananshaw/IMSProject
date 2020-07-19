
package com.manan.springcloud.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
/* import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity*/
public class Websecurity //extends WebSecurityConfigurerAdapter 
{

	private static final Logger logger = LoggerFactory.getLogger(Websecurity.class);
	
//	@Override
/*	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		logger.info("Inside Websecurity class in configure method");
		
		
		
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		
		logger.info("Inside Websecurity class in configure method");
	}
	

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
		.antMatchers("/purchase/*")
		.hasRole("ADMIN")
		.and()
		.formLogin();
		       
		      
	}
	
	*/
	
	
	
}

