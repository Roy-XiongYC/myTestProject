package com.xiongyc.product.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(description = "测试")
@RequestMapping(value = "/h5")
public class H5Controller {

	@Autowired
	private CoreController WxCore;

	@GetMapping("/redirect")
	public String redirectUrl(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state,
			Model model) {
		System.out.println(code);
		System.out.println(state);
		model.addAttribute("userInfo",WxCore.getAccessToken(code));
//		return "views/userInfo";
		return "redirect:http://47.107.87.255/admin/";
	}

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/index")
	public String queryPage() {
		return "index";
	}

//	@GetMapping("/redirect")
//	public String getToken() {
//		 return "redirect:http://47.107.87.255/admin/";
//	}
	
	@GetMapping("/redirect1")
	public void getToken(HttpServletResponse response) throws IOException {
		 response.sendRedirect("http://47.107.87.255/admin/");
	}
}