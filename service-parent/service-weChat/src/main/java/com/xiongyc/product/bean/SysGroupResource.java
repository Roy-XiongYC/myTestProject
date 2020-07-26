package com.xiongyc.product.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;


public class SysGroupResource implements IModel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	/** 
	* 鑾峰彇 无意思主键
	*/ 
	public String getId(){ return id ; } 
	/** 
	* 璁剧疆 无意思主键
	*/ 
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
	* 鑾峰彇 资源ID
	*/ 
	public String getResourceId(){ return resourceId ; } 
	/** 
	* 璁剧疆 资源ID
	*/ 
	public void setResourceId(String resourceId){ this.resourceId=resourceId ; } 
 	/** 
	* 鑾峰彇 资源访问权限0-无权限 2-可访问 2-可授权
	*/ 
	public Integer getAccessAuth(){ return accessAuth ; } 
	/** 
	* 璁剧疆 资源访问权限0-无权限 2-可访问 2-可授权
	*/ 
	public void setAccessAuth(Integer accessAuth){ this.accessAuth=accessAuth ; } 
 	public String getCreateBy(){ return createBy ; } 
	public void setCreateBy(String createBy){ this.createBy=createBy ; } 
 	public Date getCreateTime(){ return createTime ; } 
	public void setCreateTime(Date createTime){ this.createTime=createTime ; } 

 	/** 
	* 无意思主键
	*/ 
	private String id; 

 	/** 
	* 用户组ID
	*/ 
	private String groupId; 

 	/** 
	* 资源ID
	*/ 
	private String resourceId; 

 	/** 
	* 资源访问权限0-无权限 2-可访问 2-可授权
	*/ 
	private Integer accessAuth; 

 	private String createBy; 

 	private Date createTime; 



} 