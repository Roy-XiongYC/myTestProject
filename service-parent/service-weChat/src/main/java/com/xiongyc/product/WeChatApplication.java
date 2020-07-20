package com.xiongyc.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.xiongyc.product.config.ExcludeFromComponentScan;

@ComponentScan(basePackages = { "com.xiongyc" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
@MapperScan("com.xiongyc.product.dao")
@SpringBootApplication
@EnableEurekaClient
public class WeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatApplication.class, args);
	}

}
