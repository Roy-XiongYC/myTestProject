package com.xiongyc.product.controller.weChat;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "微信核心")
@RestController
@RequestMapping("core")
public class CoreController {

	@Value("wx.token")
	private String token;

	@ApiOperation(value = "验证服务器配置token")
	@GetMapping("/checkSignature")
	public void checkSignature(@RequestParam(name = "signature") String signature,
			@RequestParam(name = "timestamp") String timestamp, @RequestParam(name = "nonce") String nonce,
			@RequestParam(name = "echostr") String echostr, HttpServletResponse resp) {
		try {
			System.out.println("echostr : " + echostr);
			resp.getWriter().write(echostr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
