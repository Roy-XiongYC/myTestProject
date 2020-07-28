package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("")
public class SysDict implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * dict_id
	 */
	@ApiModelProperty(value = "dict_id")
	private String dictId;

	/**
	 * dict_code
	 */
	@ApiModelProperty(value = "dict_code")
	private String dictCode;

	/**
	 * dict_value
	 */
	@ApiModelProperty(value = "dict_value")
	private String dictValue;

	/**
	 * dict_remark
	 */
	@ApiModelProperty(value = "dict_remark")
	private String dictRemark;

	/**
	 * create_time
	 */
	@ApiModelProperty(value = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 dict_id
	 */
	public String getDictId() {
		return dictId;
	}

	/**
	 * 设置 dict_id
	 */
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	/**
	 * 获取 dict_code
	 */
	public String getDictCode() {
		return dictCode;
	}

	/**
	 * 设置 dict_code
	 */
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	/**
	 * 获取 dict_value
	 */
	public String getDictValue() {
		return dictValue;
	}

	/**
	 * 设置 dict_value
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	/**
	 * 获取 dict_remark
	 */
	public String getDictRemark() {
		return dictRemark;
	}

	/**
	 * 设置 dict_remark
	 */
	public void setDictRemark(String dictRemark) {
		this.dictRemark = dictRemark;
	}

	/**
	 * 获取 create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 create_time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}