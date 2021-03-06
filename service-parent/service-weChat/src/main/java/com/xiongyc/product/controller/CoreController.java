package com.xiongyc.product.controller;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.StringUtils;
import com.xiongyc.cache.RedisUtil;
import com.xiongyc.product.constant.WeChatConstant;
import com.xiongyc.product.result.WxResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(description = "微信核心")
@RestController
@RequestMapping("core")
public class CoreController {

	@Value("${wx.token}")
	private String token;

	@Value("${wx.appId}")
	private String appId;

	@Value("${wx.appSecret}")
	private String appSecret;

	@Value("${wx.grantType}")
	private String grantType;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisUtil redisUtil;

	
	@ApiOperation(value = "验证服务器配置token")
	@GetMapping("/checkSignature")
	public String checkSignature(@RequestParam(name = "signature") String signature,
			@RequestParam(name = "timestamp") String timestamp, @RequestParam(name = "nonce") String nonce,
			@RequestParam(name = "echostr") String echostr, HttpServletResponse resp) {
		log.info("echostr : " + echostr);
		return echostr;
	}
	
	/**
	 * 获取商户token
	 * @return
	 */
	public String getToken() {
		
		Object accessToken = redisUtil.get(WeChatConstant.ACCESSTOKEN);
		if(accessToken == null) {
			log.info("======> http 请求开始 获取 WeChatConstant.ACCESSTOKEN");
			String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/token?grant_type={0}&appid={1}&secret={2}", grantType,appId,appSecret);
			ResponseEntity<WxResult> forEntity = restTemplate.getForEntity(url, WxResult.class);
			
			if(forEntity.getStatusCodeValue() != HttpStatus.SC_OK) {
				log.error(" http 请求错误 ：" + forEntity.getStatusCode());
				return null;
			}
			if(StringUtils.isEmpty(forEntity.getBody().getAccess_token())) {
				log.error(" weChat 请求错误 ：" + forEntity.getBody().getErrcode() + "  " + forEntity.getBody().getErrmsg());
				return null;
			}
			accessToken = forEntity.getBody().getAccess_token();
			redisUtil.set(WeChatConstant.ACCESSTOKEN, accessToken, Long.valueOf(forEntity.getBody().getExpires_in()), TimeUnit.SECONDS);
		}
		return accessToken.toString();
	}
	
	/**
	 * 获取用户收授权token
	 * @return
	 */
	public WxResult getAccessToken(String code) {
		
//		Object accessToken = redisUtil.get(WeChatConstant.ACCESSTOKEN);
//		if(accessToken == null) {
		String url = MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code", appId,appSecret,code);
		ResponseEntity<WxResult> forEntity = restTemplate.getForEntity(url, WxResult.class);
		
		if(forEntity.getStatusCodeValue() != HttpStatus.SC_OK) {
			log.error(" http 请求错误 ：" + forEntity.getStatusCode());
			return null;
		}
		if(!StringUtils.isEmpty(forEntity.getBody().getErrcode())) {
			log.error(" weChat 请求错误 ：" + forEntity.getBody().getErrcode() + "  " + forEntity.getBody().getErrmsg());
			return null;
		}
		//                          https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
		url = MessageFormat.format("https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN", forEntity.getBody().getAccess_token(),forEntity.getBody().getOpenid());
		ResponseEntity<WxResult> entity = restTemplate.getForEntity(url, WxResult.class);
		if(entity.getStatusCodeValue() != HttpStatus.SC_OK) {
			log.error(" http 请求错误 ：" + entity.getStatusCode());
			return null;
		}
		if(!StringUtils.isEmpty(forEntity.getBody().getErrcode())) {
			log.error(" weChat 请求错误 ：" + entity.getBody().getErrcode() + "  " + entity.getBody().getErrmsg());
			return null;
		}
		return entity.getBody();
	}
	
}
