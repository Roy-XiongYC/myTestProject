package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("测试数据模型")
public class SysTest implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@ApiModelProperty(value = "编号")
	private String id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "备注测试")
	private String batTest;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatTest() {
		return batTest;
	}

	public void setBatTest(String batTest) {
		this.batTest = batTest;
	}

}