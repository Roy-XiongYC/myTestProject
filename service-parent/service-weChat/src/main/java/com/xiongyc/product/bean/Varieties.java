package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("品种数据")
public class Varieties implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 品种编号
	 */
	@ApiModelProperty(value = "品种编号")
	private String varietiesId;

	/**
	 * 品种名称
	 */
	@ApiModelProperty(value = "品种名称")
	private String varietiesName;

	/**
	 * 分类编号
	 */
	@ApiModelProperty(value = "分类编号")
	private String classId;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 品种编号
	 */
	public String getVarietiesId() {
		return varietiesId;
	}

	/**
	 * 设置 品种编号
	 */
	public void setVarietiesId(String varietiesId) {
		this.varietiesId = varietiesId;
	}

	/**
	 * 获取 品种名称
	 */
	public String getVarietiesName() {
		return varietiesName;
	}

	/**
	 * 设置 品种名称
	 */
	public void setVarietiesName(String varietiesName) {
		this.varietiesName = varietiesName;
	}

	/**
	 * 获取 分类编号
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * 设置 分类编号
	 */
	public void setClassId(String classId) {
		this.classId = classId;
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