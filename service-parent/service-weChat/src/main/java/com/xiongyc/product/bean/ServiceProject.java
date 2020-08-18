package com.xiongyc.product.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("服务项目")
public class ServiceProject implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 服务编号
	 */
	@ApiModelProperty(value = "服务编号")
	private String serviceId;

	/**
	 * 启用状态 0 启用 1 未启用
	 */
	@ApiModelProperty(value = "启用状态 0 启用 1 未启用")
	private String delStatus;

	/**
	 * 服务类型 10 美容洗澡 20 寄养
	 */
	@ApiModelProperty(value = "服务类型 10 美容洗澡 20 寄养")
	private String type;

	/**
	 * 服务项目
	 */
	@ApiModelProperty(value = "服务项目")
	private String projectName;

	/**
	 * 金额
	 */
	@ApiModelProperty(value = "金额")
	private BigDecimal price;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 服务编号
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * 设置 服务编号
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * 获取 启用状态 0 启用 1 未启用
	 */
	public String getDelStatus() {
		return delStatus;
	}

	/**
	 * 设置 启用状态 0 启用 1 未启用
	 */
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	/**
	 * 获取 服务类型 10 美容洗澡 20 寄养
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置 服务类型 10 美容洗澡 20 寄养
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取 服务项目
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 设置 服务项目
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 获取 金额
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置 金额
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}