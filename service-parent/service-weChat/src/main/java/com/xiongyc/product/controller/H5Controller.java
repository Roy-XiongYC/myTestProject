package com.xiongyc.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiongyc.product.bean.ShopUser;
import com.xiongyc.product.result.WxResult;
import com.xiongyc.product.service.IShopUserService;

import io.swagger.annotations.Api;

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

}