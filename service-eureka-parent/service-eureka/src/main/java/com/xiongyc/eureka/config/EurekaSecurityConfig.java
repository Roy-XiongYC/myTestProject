package com.xiongyc.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author YouCai.Xiong
 * @Date 2020年4月10日 - 下午2:50:01
 * @Info 初始版本 eureka 安全验证放行
 * @Version 1.0
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
