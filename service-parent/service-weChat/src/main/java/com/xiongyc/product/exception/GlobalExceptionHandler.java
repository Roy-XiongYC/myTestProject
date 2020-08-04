package com.xiongyc.product.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.result.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = RuntimeException.class)
	public JsonResult<Object> bizExceptionHandler(HttpServletRequest req, RuntimeException e) {
		log.error("发生业务异常！原因是：{}", e.getMessage());
		return AppResponseCode.failure(AppResponseCode.RESPONSE_CODE_SYSTEM_ERROR);
	}

	/**
	 * 处理空指针的异常
	 * 
	 * @param req
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = NullPointerException.class)
	public JsonResult<Object> exceptionHandler(HttpServletRequest req, NullPointerException e) {
		log.error("发生空指针异常！原因是:", e);
		return AppResponseCode.failure(AppResponseCode.RESPONSE_CODE_PARAM_ERROR);
	}

	/**
	 * 处理其他异常
	 * 
	 * @param req
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public JsonResult<Object> exceptionHandler(HttpServletRequest req, Exception e) {
		log.error("未知异常！原因是:", e);
		return AppResponseCode.failure(AppResponseCode.RESPONSE_CODE_SYSTEM_ERROR);
	}
}

