package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.xiongyc.utils.mybatis.IModel;


public class SysDict implements IModel { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	/** 
	* 鑾峰彇 无意义主键
	*/ 
	public String getId(){ return id ; } 
	/** 
	* 璁剧疆 无意义主键
	*/ 
	public void setId(String id){ this.id=id ; } 
 	/** 
	* 鑾峰彇 数据字典键
	*/ 
	public String getDictCode(){ return dictCode ; } 
	/** 
	* 璁剧疆 数据字典键
	*/ 
	public void setDictCode(String dictCode){ this.dictCode=dictCode ; } 
 	/** 
	* 鑾峰彇 数据字典值
	*/ 
	public String getDictValue(){ return dictValue ; } 
	/** 
	* 璁剧疆 数据字典值
	*/ 
	public void setDictValue(String dictValue){ this.dictValue=dictValue ; } 
 	/** 
	* 鑾峰彇 数据字典描述
	*/ 
	public String getDictRemark(){ return dictRemark ; } 
	/** 
	* 璁剧疆 数据字典描述
	*/ 
	public void setDictRemark(String dictRemark){ this.dictRemark=dictRemark ; } 

 	/** 
	* 无意义主键
	*/ 
	private String id; 

 	/** 
	* 数据字典键
	*/ 
	private String dictCode; 

 	/** 
	* 数据字典值
	*/ 
	private String dictValue; 

 	/** 
	* 数据字典描述
	*/ 
	private String dictRemark; 



} 