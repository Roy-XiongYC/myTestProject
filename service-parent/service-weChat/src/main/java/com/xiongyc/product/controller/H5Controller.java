package com.xiongyc.product.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xiongyc.product.bean.ShopUser;
import com.xiongyc.product.result.WxResult;
import com.xiongyc.product.service.IShopUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(description = "测试")
@RequestMapping(value = "/h5")
public class H5Controller {

	@Autowired
	private CoreController WxCore;

	@Autowired
	private IShopUserService shopUserService;

	@RequestMapping("/redirect")
	public String redirectUrl(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
		System.out.println(code);
		System.out.println(state);
		WxResult accessToken = WxCore.getAccessToken(code);
		System.out.println("==========:" + accessToken.toString());
		ShopUser user = shopUserService.saveUser(accessToken);
		return "redirect:http://www.dikachongwu.com/h5/?userId=" + user.getUserId();
	}

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/index")
	public String queryPage() {
		return "index";
	}

//	@GetMapping("/redirect")
//	public String getToken(HttpServletRequest request, HttpServletResponse response, Model model)
//			throws UnsupportedEncodingException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		// request域中设置一个属性
//		WxResult userInfo = new WxResult();
//		userInfo.setOpenid("1111");
//		model.addAttribute("userInfo", userInfo);
//		request.setAttribute("userInfo", userInfo);
//		return "redirect:http://www.dikachongwu.com/h5/";
//	}

	@GetMapping("/redirect1")
	public void getToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// request域中设置一个属性
		WxResult userInfo = new WxResult();
		userInfo.setOpenid("1111");
		request.setAttribute("userInfo", userInfo);
		response.sendRedirect("http://47.107.87.255/h5/");
	}
}