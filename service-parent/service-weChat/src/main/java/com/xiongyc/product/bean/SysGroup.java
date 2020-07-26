package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;


public class SysGroup implements IModel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	/** 
	* 鑾峰彇 用户组ID
	*/ 
	public String getGroupId(){ return groupId ; } 
	/** 
	* 璁剧疆 用户组ID
	*/ 
	public void setGroupId(String groupId){ this.groupId=groupId ; } 
 	/** 
	* 鑾峰彇 用户组名
	*/ 
	public String getGroupName(){ return groupName ; } 
	/** 
	* 璁剧疆 用户组名
	*/ 
	public void setGroupName(String groupName){ this.groupName=groupName ; } 
 	/** 
	* 鑾峰彇 组状态
0-停用 1-启用 2-删除
	*/ 
	public Integer getGroupStatus(){ return groupStatus ; } 
	/** 
	* 璁剧疆 组状态
0-停用 1-启用 2-删除
	*/ 
	public void setGroupStatus(Integer groupStatus){ this.groupStatus=groupStatus ; } 
 	public String getCreateBy(){ return createBy ; } 
	public void setCreateBy(String createBy){ this.createBy=createBy ; } 
 	public Date getCreateTime(){ return createTime ; } 
	public void setCreateTime(Date createTime){ this.createTime=createTime ; } 

 	/** 
	* 用户组ID
	*/ 
	private String groupId; 

 	/** 
	* 用户组名
	*/ 
	private String groupName; 

 	/** 
	* 组状态
0-停用 1-启用 2-删除
	*/ 
//	@Dict(dictCode="userStatus")
	private Integer groupStatus; 

 	private String createBy; 

 	private Date createTime; 



} 