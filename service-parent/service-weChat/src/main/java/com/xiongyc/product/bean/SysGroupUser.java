package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;


public class SysGroupUser implements IModel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	public String getId(){ return id ; } 
	public void setId(String id){ this.id=id ; } 
 	/** 
	* 鑾峰彇 用户组ID
	*/ 
	public String getGroupId(){ return groupId ; } 
	/** 
	* 璁剧疆 用户组ID
	*/ 
	public void setGroupId(String groupId){ this.groupId=groupId ; } 
 	/** 
	* 鑾峰彇 用户ID
	*/ 
	public String getUserId(){ return userId ; } 
	/** 
	* 璁剧疆 用户ID
	*/ 
	public void setUserId(String userId){ this.userId=userId ; } 

 	private String id; 

 	/** 
	* 用户组ID
	*/ 
	private String groupId; 

 	/** 
	* 用户ID
	*/ 
	private String userId; 



} 