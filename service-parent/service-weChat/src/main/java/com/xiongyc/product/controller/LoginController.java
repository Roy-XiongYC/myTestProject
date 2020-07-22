package com.xiongyc.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(description = "登录")
//@RequestMapping(value = "/login")
public class LoginController {

//	@Autowired
//	private SequenceService sequenceService;

	@ApiOperation(value = "登录页")
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@ApiOperation(value = "登录页")
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}