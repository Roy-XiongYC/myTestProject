package com.xiongyc.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiongyc.utils.mybatis.IModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("管理员表")
public class SysUser implements IModel { 

	private static final long serialVersionUID = 1L; 

	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	/** 
	* 主键id
	*/ 
    @ApiModelProperty(value ="主键id")
	private Long uSERID; 

 	/** 
	* 头像
	*/ 
    @ApiModelProperty(value ="头像")
	private String aVATAR; 

 	/** 
	* 账号
	*/ 
    @ApiModelProperty(value ="账号")
	private String aCCOUNT; 

 	/** 
	* 密码
	*/ 
    @ApiModelProperty(value ="密码")
	private String pASSWORD; 

 	/** 
	* md5密码盐
	*/ 
    @ApiModelProperty(value ="md5密码盐")
	private String sALT; 

 	/** 
	* 名字
	*/ 
    @ApiModelProperty(value ="名字")
	private String nAME; 

 	/** 
	* 生日
	*/ 
    @ApiModelProperty(value ="生日")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
	private Date bIRTHDAY; 

 	/** 
	* 性别（0表示未定义，1表示男性，2表示女性）
	*/ 
    @ApiModelProperty(value ="性别（0表示未定义，1表示男性，2表示女性）")
	private String sEX; 

 	/** 
	* 电子邮件
	*/ 
    @ApiModelProperty(value ="电子邮件")
	private String eMAIL; 

 	/** 
	* 电话
	*/ 
    @ApiModelProperty(value ="电话")
	private String pHONE; 

 	/** 
	* 角色id(多个逗号隔开)
	*/ 
    @ApiModelProperty(value ="角色id(多个逗号隔开)")
	private String rOLEID; 

 	/** 
	* 部门id(多个逗号隔开)
	*/ 
    @ApiModelProperty(value ="部门id(多个逗号隔开)")
	private Long dEPTID; 

 	/** 
	* 状态(ENABLE-启用，DISABLE-冻结,DELETED-删除)
	*/ 
    @ApiModelProperty(value ="状态(ENABLE-启用，DISABLE-冻结,DELETED-删除)")
	private String sTATUS; 

 	/** 
	* 乐观锁
	*/ 
    @ApiModelProperty(value ="乐观锁")
	private Integer vERSION; 

 	/** 
	* 职务信息
	*/ 
    @ApiModelProperty(value ="职务信息")
	private String pOSITION; 

 	/** 
	* 加入时间
	*/ 
    @ApiModelProperty(value ="加入时间")
	private String eNTRYTIME; 

 	/** 
	* 表示在所在的部门内是否为上级
	*/ 
    @ApiModelProperty(value ="表示在所在的部门内是否为上级")
	private String iSLEADER; 

 	/** 
	* 座机
	*/ 
    @ApiModelProperty(value ="座机")
	private String tELEPHONE; 

 	/** 
	* 激活状态（1=已激活，2=已禁用，4=未激活 ）
	*/ 
    @ApiModelProperty(value ="激活状态（1=已激活，2=已禁用，4=未激活 ）")
	private String aCTSTATUS; 


 	/** 
	* 获取 主键id
	*/ 
	public Long getUSERID(){ return uSERID ; } 
	/** 
	* 设置 主键id
	*/ 
	public void setUSERID(Long uSERID){ this.uSERID=uSERID ; } 
 	/** 
	* 获取 头像
	*/ 
	public String getAVATAR(){ return aVATAR ; } 
	/** 
	* 设置 头像
	*/ 
	public void setAVATAR(String aVATAR){ this.aVATAR=aVATAR ; } 
 	/** 
	* 获取 账号
	*/ 
	public String getACCOUNT(){ return aCCOUNT ; } 
	/** 
	* 设置 账号
	*/ 
	public void setACCOUNT(String aCCOUNT){ this.aCCOUNT=aCCOUNT ; } 
 	/** 
	* 获取 密码
	*/ 
	public String getPASSWORD(){ return pASSWORD ; } 
	/** 
	* 设置 密码
	*/ 
	public void setPASSWORD(String pASSWORD){ this.pASSWORD=pASSWORD ; } 
 	/** 
	* 获取 md5密码盐
	*/ 
	public String getSALT(){ return sALT ; } 
	/** 
	* 设置 md5密码盐
	*/ 
	public void setSALT(String sALT){ this.sALT=sALT ; } 
 	/** 
	* 获取 名字
	*/ 
	public String getNAME(){ return nAME ; } 
	/** 
	* 设置 名字
	*/ 
	public void setNAME(String nAME){ this.nAME=nAME ; } 
 	/** 
	* 获取 生日
	*/ 
	public Date getBIRTHDAY(){ return bIRTHDAY ; } 
	/** 
	* 设置 生日
	*/ 
	public void setBIRTHDAY(Date bIRTHDAY){ this.bIRTHDAY=bIRTHDAY ; } 
 	/** 
	* 获取 性别（0表示未定义，1表示男性，2表示女性）
	*/ 
	public String getSEX(){ return sEX ; } 
	/** 
	* 设置 性别（0表示未定义，1表示男性，2表示女性）
	*/ 
	public void setSEX(String sEX){ this.sEX=sEX ; } 
 	/** 
	* 获取 电子邮件
	*/ 
	public String getEMAIL(){ return eMAIL ; } 
	/** 
	* 设置 电子邮件
	*/ 
	public void setEMAIL(String eMAIL){ this.eMAIL=eMAIL ; } 
 	/** 
	* 获取 电话
	*/ 
	public String getPHONE(){ return pHONE ; } 
	/** 
	* 设置 电话
	*/ 
	public void setPHONE(String pHONE){ this.pHONE=pHONE ; } 
 	/** 
	* 获取 角色id(多个逗号隔开)
	*/ 
	public String getROLEID(){ return rOLEID ; } 
	/** 
	* 设置 角色id(多个逗号隔开)
	*/ 
	public void setROLEID(String rOLEID){ this.rOLEID=rOLEID ; } 
 	/** 
	* 获取 部门id(多个逗号隔开)
	*/ 
	public Long getDEPTID(){ return dEPTID ; } 
	/** 
	* 设置 部门id(多个逗号隔开)
	*/ 
	public void setDEPTID(Long dEPTID){ this.dEPTID=dEPTID ; } 
 	/** 
	* 获取 状态(ENABLE-启用，DISABLE-冻结,DELETED-删除)
	*/ 
	public String getSTATUS(){ return sTATUS ; } 
	/** 
	* 设置 状态(ENABLE-启用，DISABLE-冻结,DELETED-删除)
	*/ 
	public void setSTATUS(String sTATUS){ this.sTATUS=sTATUS ; } 
 	/** 
	* 获取 乐观锁
	*/ 
	public Integer getVERSION(){ return vERSION ; } 
	/** 
	* 设置 乐观锁
	*/ 
	public void setVERSION(Integer vERSION){ this.vERSION=vERSION ; } 
 	/** 
	* 获取 职务信息
	*/ 
	public String getPOSITION(){ return pOSITION ; } 
	/** 
	* 设置 职务信息
	*/ 
	public void setPOSITION(String pOSITION){ this.pOSITION=pOSITION ; } 
 	/** 
	* 获取 加入时间
	*/ 
	public String getENTRYTIME(){ return eNTRYTIME ; } 
	/** 
	* 设置 加入时间
	*/ 
	public void setENTRYTIME(String eNTRYTIME){ this.eNTRYTIME=eNTRYTIME ; } 
 	/** 
	* 获取 表示在所在的部门内是否为上级
	*/ 
	public String getISLEADER(){ return iSLEADER ; } 
	/** 
	* 设置 表示在所在的部门内是否为上级
	*/ 
	public void setISLEADER(String iSLEADER){ this.iSLEADER=iSLEADER ; } 
 	/** 
	* 获取 座机
	*/ 
	public String getTELEPHONE(){ return tELEPHONE ; } 
	/** 
	* 设置 座机
	*/ 
	public void setTELEPHONE(String tELEPHONE){ this.tELEPHONE=tELEPHONE ; } 
 	/** 
	* 获取 激活状态（1=已激活，2=已禁用，4=未激活 ）
	*/ 
	public String getACTSTATUS(){ return aCTSTATUS ; } 
	/** 
	* 设置 激活状态（1=已激活，2=已禁用，4=未激活 ）
	*/ 
	public void setACTSTATUS(String aCTSTATUS){ this.aCTSTATUS=aCTSTATUS ; } 


} 