package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("宠物分类")
public class PetsClass implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 分类编码
	 */
	@ApiModelProperty(value = "分类编码")
	private String classId;

	/**
	 * 父类ID 0 最上级
	 */
	@ApiModelProperty(value = "父类ID 0 最上级")
	private String parentId;

	/**
	 * 分类名称
	 */
	@ApiModelProperty(value = "分类名称")
	private String className;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private String orderBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 分类编码
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * 设置 分类编码
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * 获取 父类ID 0 最上级
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置 父类ID 0 最上级
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取 分类名称
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 设置 分类名称
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 获取 排序
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置 排序
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
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