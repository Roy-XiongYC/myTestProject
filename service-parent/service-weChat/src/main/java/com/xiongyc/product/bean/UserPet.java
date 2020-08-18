package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户宠物")
public class UserPet implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 宠物名称
	 */
	@ApiModelProperty(value = "宠物名称")
	private String petId;

	@ApiModelProperty(value = "")
	private String userId;

	/**
	 * 宠物类型编号
	 */
	@ApiModelProperty(value = "宠物类型编号")
	private String petTypeId;

	/**
	 * 宠物名称
	 */
	@ApiModelProperty(value = "宠物名称")
	private String petName;

	/**
	 * 宠物明细
	 */
	@ApiModelProperty(value = "宠物明细")
	private String petInfo;

	/**
	 * 生日
	 */
	@ApiModelProperty(value = "生日")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
	private Date petBirthday;

	/**
	 * 0母1公
	 */
	@ApiModelProperty(value = "0母1公")
	private String sex;

	/**
	 * 品种
	 */
	@ApiModelProperty(value = "品种")
	private String varieties;

	/**
	 * 联系电话
	 */
	@ApiModelProperty(value = "联系电话")
	private String mobile;

	/**
	 * 绝育 1 是 0 否
	 */
	@ApiModelProperty(value = "绝育 1 是 0 否")
	private Boolean sterilization;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 宠物名称
	 */
	public String getPetId() {
		return petId;
	}

	/**
	 * 设置 宠物名称
	 */
	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取 宠物类型编号
	 */
	public String getPetTypeId() {
		return petTypeId;
	}

	/**
	 * 设置 宠物类型编号
	 */
	public void setPetTypeId(String petTypeId) {
		this.petTypeId = petTypeId;
	}

	/**
	 * 获取 宠物名称
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * 设置 宠物名称
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * 获取 宠物明细
	 */
	public String getPetInfo() {
		return petInfo;
	}

	/**
	 * 设置 宠物明细
	 */
	public void setPetInfo(String petInfo) {
		this.petInfo = petInfo;
	}

	/**
	 * 获取 生日
	 */
	public Date getPetBirthday() {
		return petBirthday;
	}

	/**
	 * 设置 生日
	 */
	public void setPetBirthday(Date petBirthday) {
		this.petBirthday = petBirthday;
	}

	/**
	 * 获取 0母1公
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置 0母1公
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取 品种
	 */
	public String getVarieties() {
		return varieties;
	}

	/**
	 * 设置 品种
	 */
	public void setVarieties(String varieties) {
		this.varieties = varieties;
	}

	/**
	 * 获取 联系电话
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置 联系电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取 绝育 1 是 0 否
	 */
	public Boolean getSterilization() {
		return sterilization;
	}

	/**
	 * 设置 绝育 1 是 0 否
	 */
	public void setSterilization(Boolean sterilization) {
		this.sterilization = sterilization;
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