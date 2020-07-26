package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.xiongyc.utils.mybatis.IModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


@ApiModel("商城用户表")
public class ShopUser implements IModel { 

	private static final long serialVersionUID = 1L; 

	public String toString() {return ReflectionToStringBuilder.toString(this);}

     @ApiModelProperty(value ="")
	private String userId; 

 	/** 
	* 名称
	*/ 
    @ApiModelProperty(value ="名称")
	private String nickName; 

 	/** 
	* 微信unionId
	*/ 
    @ApiModelProperty(value ="微信unionId")
	private String unionId; 

 	/** 
	* 积分
	*/ 
    @ApiModelProperty(value ="积分")
	private Integer integral; 

 	/** 
	* 密码
	*/ 
    @ApiModelProperty(value ="密码")
	private String pwd; 

 	/** 
	* 用户头像
	*/ 
    @ApiModelProperty(value ="用户头像")
	private String headimgurl; 

 	/** 
	* qq
	*/ 
    @ApiModelProperty(value ="qq")
	private String mobile; 

 	/** 
	* 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	*/ 
    @ApiModelProperty(value ="用户的性别，值为1时是男性，值为2时是女性，值为0时是未知")
	private Long sex; 

 	/** 
	* 国家，如中国为CN
	*/ 
    @ApiModelProperty(value ="国家，如中国为CN")
	private String country; 

 	/** 
	* 省份
	*/ 
    @ApiModelProperty(value ="省份")
	private String province; 

 	/** 
	* 城市
	*/ 
    @ApiModelProperty(value ="城市")
	private String city; 

     @ApiModelProperty(value ="")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
	private Date createTime; 


 	public String getUserId(){ return userId ; } 
	public void setUserId(String userId){ this.userId=userId ; } 
 	/** 
	* 获取 名称
	*/ 
	public String getNickName(){ return nickName ; } 
	/** 
	* 设置 名称
	*/ 
	public void setNickName(String nickName){ this.nickName=nickName ; } 
 	/** 
	* 获取 微信unionId
	*/ 
	public String getUnionId(){ return unionId ; } 
	/** 
	* 设置 微信unionId
	*/ 
	public void setUnionId(String unionId){ this.unionId=unionId ; } 
 	/** 
	* 获取 积分
	*/ 
	public Integer getIntegral(){ return integral ; } 
	/** 
	* 设置 积分
	*/ 
	public void setIntegral(Integer integral){ this.integral=integral ; } 
 	/** 
	* 获取 密码
	*/ 
	public String getPwd(){ return pwd ; } 
	/** 
	* 设置 密码
	*/ 
	public void setPwd(String pwd){ this.pwd=pwd ; } 
 	/** 
	* 获取 用户头像
	*/ 
	public String getHeadimgurl(){ return headimgurl ; } 
	/** 
	* 设置 用户头像
	*/ 
	public void setHeadimgurl(String headimgurl){ this.headimgurl=headimgurl ; } 
 	/** 
	* 获取 qq
	*/ 
	public String getMobile(){ return mobile ; } 
	/** 
	* 设置 qq
	*/ 
	public void setMobile(String mobile){ this.mobile=mobile ; } 
 	/** 
	* 获取 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	*/ 
	public Long getSex(){ return sex ; } 
	/** 
	* 设置 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	*/ 
	public void setSex(Long sex){ this.sex=sex ; } 
 	/** 
	* 获取 国家，如中国为CN
	*/ 
	public String getCountry(){ return country ; } 
	/** 
	* 设置 国家，如中国为CN
	*/ 
	public void setCountry(String country){ this.country=country ; } 
 	/** 
	* 获取 省份
	*/ 
	public String getProvince(){ return province ; } 
	/** 
	* 设置 省份
	*/ 
	public void setProvince(String province){ this.province=province ; } 
 	/** 
	* 获取 城市
	*/ 
	public String getCity(){ return city ; } 
	/** 
	* 设置 城市
	*/ 
	public void setCity(String city){ this.city=city ; } 
 	public Date getCreateTime(){ return createTime ; } 
	public void setCreateTime(Date createTime){ this.createTime=createTime ; } 


} 