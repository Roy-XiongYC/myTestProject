package com.xiongyc.product.controller.weChat.result;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信result")
public class WxResult implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@ApiModelProperty(value = "编码")
	private String errcode;

	@ApiModelProperty(value = "msg")
	private String errmsg;

	@ApiModelProperty(value = "授权accessToken")
	private String access_token;

	@ApiModelProperty(value = "有限时间")
	private String expires_in;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

}