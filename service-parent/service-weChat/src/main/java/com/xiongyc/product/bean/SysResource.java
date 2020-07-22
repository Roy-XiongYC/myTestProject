package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;

public class SysResource implements IModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 鑾峰彇 资源Id
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * 璁剧疆 资源Id
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * 鑾峰彇 资源编号
	 */
	public String getResourceCode() {
		return resourceCode;
	}

	/**
	 * 璁剧疆 资源编号
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	/**
	 * 鑾峰彇 资源名称
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * 璁剧疆 资源名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * 鑾峰彇 资源类型 0-菜单目录 1-菜单URL 2-按钮
	 */
	public Integer getResourceType() {
		return resourceType;
	}

	/**
	 * 璁剧疆 资源类型 0-菜单目录 1-菜单URL 2-按钮
	 */
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 鑾峰彇 资源父Id
	 */
	public String getParentResourceId() {
		return parentResourceId;
	}

	/**
	 * 璁剧疆 资源父Id
	 */
	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	/**
	 * 鑾峰彇 序号
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 璁剧疆 序号
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	/**
	 * 资源Id
	 */
	private String resourceId;

	/**
	 * 资源编号
	 */
	private String resourceCode;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源类型 0-菜单目录 1-菜单URL 2-按钮
	 */
//	@Dict(dictCode = "resourceType")
	private Integer resourceType;

	private String url;

	/**
	 * 资源父Id
	 */
	private String parentResourceId;

	/**
	 * 序号
	 */
	private Integer orderNumber;

	private String createBy;
	private String iconClass;

	private Integer accessAuth;

	private Date createTime;

	public Integer getAccessAuth() {
		return accessAuth;
	}

	public void setAccessAuth(Integer accessAuth) {
		this.accessAuth = accessAuth;
	}

}