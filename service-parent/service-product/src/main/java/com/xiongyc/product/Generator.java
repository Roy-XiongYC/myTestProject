package com.xiongyc.product;

import org.springframework.stereotype.Controller;

import com.xiongyc.generator.Enter;

@Controller
public class Generator {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		new Enter().main(args);
	}
}
