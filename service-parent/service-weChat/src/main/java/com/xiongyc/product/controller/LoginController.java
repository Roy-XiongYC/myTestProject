package com.xiongyc.product.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiongyc.cache.RedisUtil;
import com.xiongyc.product.bean.SysUser;
import com.xiongyc.product.constant.DefaultConstant;
import com.xiongyc.product.constant.RedisConstant;
import com.xiongyc.product.service.ISysUserService;
import com.xiongyc.product.utils.EncryptUtil;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(description = "登录")
@RequestMapping("admin")
public class LoginController {

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ISysUserService sysUserService;

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

	@ApiOperation(value = "登录页")
	@GetMapping("/welcome.html")
	public String welcome() {
		return "welcome";
	}
	
	

	@ResponseBody
	@PostMapping(value = "login")
	public JsonResult<Object> login(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String username,
			@RequestParam(required = true) String password) {
		// 编写登录
		Criteria<SysUser> param = new Criteria<SysUser>();
		param.addParam("userName", username);
		SysUser userinfo = sysUserService.loginSys(param);
		if (userinfo == null) {
			return AppResponseCode.failure(AppResponseCode.C00020);
		}
		if (DefaultConstant.USER_ACTIVE != userinfo.getUserStatus()) {
			return AppResponseCode.fail("当前用户已锁定或失效不可登陆");
		}
		// 验证用户账号与密码是否对应
		String pwd = userinfo.getPassword();
		if (!EncryptUtil.validatePassword(password, pwd,userinfo.getUserId())) {
			int misTimes = 10;
			// 用户密码不匹配则修改错误密码次数
			userinfo.setPasswordRepTimes(userinfo.getPasswordRepTimes() + 1);
			int times = userinfo.getPasswordRepTimes();
			if (times >= misTimes) {
				// 如果超过尝试次数则锁定
				userinfo.setUserStatus(DefaultConstant.USER_STOP);
				times = misTimes;
			}
			sysUserService.insertOrUpdate(userinfo);
			return AppResponseCode.fail("用户密码不匹配，再录入失败 "+ (misTimes - times) +" 次后将锁定当前用户");
		}
		if (userinfo.getPasswordRepTimes() > 0) {
			userinfo.setPasswordRepTimes(0);
			sysUserService.insertOrUpdate(userinfo);
		}
		
		response = setCookieAndRedis(userinfo,response);
		
		return AppResponseCode.success();
	}
	
	
	private HttpServletResponse setCookieAndRedis(SysUser user,HttpServletResponse response){
		String redisKey = user.getUserId() + "_" + user.getUserName();
		//创建Cookie
		Cookie cookie = new Cookie(RedisConstant.COOKIE_NAME, redisKey);
		cookie.setPath("/");
		cookie.setMaxAge(-1); 	//	设置cook过期时间为: 关闭浏览器后过期
		response.addCookie(cookie);
		redisUtil.set(redisKey, redisKey + "_" + user.getPassword());
		return response;
	}
}