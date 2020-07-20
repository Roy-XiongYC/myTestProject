package com.xiongyc.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(description = "测试")
@RequestMapping(value = "/h5")
public class H5Controller {

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/index")
	public String queryPage() {
		return "index";
	}

}