package com.xiongyc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "微信oauth2 验证")
@RestController
//@RequestMapping("core")
public class Oauth2Controller {

	@ApiOperation(value = "验证服务器配置token")
	@GetMapping("/oauth2")
	public String oauth2(){
		return "e5cz4yamK9yfc950";
	}
}
