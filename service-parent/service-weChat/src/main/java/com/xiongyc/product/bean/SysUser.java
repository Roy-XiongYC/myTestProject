package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

//import com.person.framework.annotation.Dict;
import com.xiongyc.utils.mybatis.IModel;

public class SysUser implements IModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 鑾峰彇 用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 璁剧疆 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 鑾峰彇 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 璁剧疆 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 鑾峰彇 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 璁剧疆 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 鑾峰彇 用户状态 0-停用 1-启用 2-删除
	 * 
	 */
	public Integer getUserStatus() {
		return userStatus;
	}

	/**
	 * 璁剧疆 用户状态 0-停用 1-启用 2-删除
	 * 
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * 鑾峰彇 邮箱地址
	 */
	public String getEmailAddr() {
		return emailAddr;
	}

	/**
	 * 璁剧疆 邮箱地址
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	/**
	 * 鑾峰彇 手机号
	 */
	public String getMpNo() {
		return mpNo;
	}

	/**
	 * 璁剧疆 手机号
	 */
	public void setMpNo(String mpNo) {
		this.mpNo = mpNo;
	}

	/**
	 * 鑾峰彇 密码过期日期
	 */
	public Date getPasswordExpDate() {
		return passwordExpDate;
	}

	/**
	 * 璁剧疆 密码过期日期
	 */
	public void setPasswordExpDate(Date passwordExpDate) {
		this.passwordExpDate = passwordExpDate;
	}

	/**
	 * 鑾峰彇 密码错误次数
	 */
	public Integer getPasswordRepTimes() {
		return passwordRepTimes;
	}

	/**
	 * 璁剧疆 密码错误次数
	 */
	public void setPasswordRepTimes(Integer passwordRepTimes) {
		this.passwordRepTimes = passwordRepTimes;
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

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户状态 0-停用 1-启用 2-删除
	 * 
	 */
//	@Dict(dictCode="userStatus")
	private Integer userStatus;

	/**
	 * 邮箱地址
	 */
	private String emailAddr;

	/**
	 * 手机号
	 */
	private String mpNo;

	/**
	 * 密码过期日期
	 */
	private Date passwordExpDate;

	/**
	 * 密码错误次数
	 */
	private Integer passwordRepTimes;

	private String createBy;

	private Date createTime;

	private String ip;
	private String groupName;
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}