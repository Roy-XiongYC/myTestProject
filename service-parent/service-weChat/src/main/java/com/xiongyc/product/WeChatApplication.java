package com.xiongyc.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.xiongyc.product.config.ExcludeFromComponentScan;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;

@EnableHasor
@EnableHasorWeb
@ComponentScan(basePackages = { "com.xiongyc","net.example.hasor" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
@MapperScan("com.xiongyc.product.dao")
@SpringBootApplication
public class WeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatApplication.class, args);
	}

}
