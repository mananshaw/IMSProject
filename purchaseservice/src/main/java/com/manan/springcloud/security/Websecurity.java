/*package com.manan.springcloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.out.println("Inside Websecurity class");
		
		auth.inMemoryAuthentication().withUser("user1").password("password").roles("USER");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder( ) {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
		.antMatchers("/ims/update/dtd/")
		.hasRole("USER")
		.and()
		.formLogin();
		       
		      
	}
	
	
	
	
	
}
*/