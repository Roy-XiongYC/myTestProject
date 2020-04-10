package com.xiongyc.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author YC Xiong
 *
 */
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.csrf().ignoringAntMatchers("/eureka/**");
		super.configure(http);
	}

}
