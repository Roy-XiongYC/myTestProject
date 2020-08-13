package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.xiongyc.utils.mybatis.IModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


@ApiModel("商城商品表")
public class ShopGood implements IModel { 

	private static final long serialVersionUID = 1L; 

	public String toString() {return ReflectionToStringBuilder.toString(this);}

 	/** 
	* 商品编号
	*/ 
    @ApiModelProperty(value ="商品编号")
	private String goodId; 

 	/** 
	* 商品名称
	*/ 
    @ApiModelProperty(value ="商品名称")
	private String goodName; 

 	/** 
	* 商品数量
	*/ 
    @ApiModelProperty(value ="商品数量")
	private Integer goodNum; 

 	/** 
	* 商品图片地址
	*/ 
    @ApiModelProperty(value ="商品图片地址")
	private String goodPic; 

 	/** 
	* 商品详情
	*/ 
    @ApiModelProperty(value ="商品详情")
	private String goodInfo; 

 	/** 
	* 商品金额
	*/ 
    @ApiModelProperty(value ="商品金额")
	private BigDecimal goodPrice; 

 	/** 
	* 支付金额
	*/ 
    @ApiModelProperty(value ="支付金额")
	private BigDecimal payPrice; 

 	/** 
	* 商品状态(10 已上架 20 已下架 ) 
	*/ 
    @ApiModelProperty(value ="商品状态(10 已上架 20 已下架 ) ")
	private Boolean goodStatus; 

 	/** 
	* 创建时间
	*/ 
    @ApiModelProperty(value ="创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
	private Date createTime; 


 	/** 
	* 获取 商品编号
	*/ 
	public String getGoodId(){ return goodId ; } 
	/** 
	* 设置 商品编号
	*/ 
	public void setGoodId(String goodId){ this.goodId=goodId ; } 
 	/** 
	* 获取 商品名称
	*/ 
	public String getGoodName(){ return goodName ; } 
	/** 
	* 设置 商品名称
	*/ 
	public void setGoodName(String goodName){ this.goodName=goodName ; } 
 	/** 
	* 获取 商品数量
	*/ 
	public Integer getGoodNum(){ return goodNum ; } 
	/** 
	* 设置 商品数量
	*/ 
	public void setGoodNum(Integer goodNum){ this.goodNum=goodNum ; } 
 	/** 
	* 获取 商品图片地址
	*/ 
	public String getGoodPic(){ return goodPic ; } 
	/** 
	* 设置 商品图片地址
	*/ 
	public void setGoodPic(String goodPic){ this.goodPic=goodPic ; } 
 	/** 
	* 获取 商品详情
	*/ 
	public String getGoodInfo(){ return goodInfo ; } 
	/** 
	* 设置 商品详情
	*/ 
	public void setGoodInfo(String goodInfo){ this.goodInfo=goodInfo ; } 
 	/** 
	* 获取 商品金额
	*/ 
	public BigDecimal getGoodPrice(){ return goodPrice ; } 
	/** 
	* 设置 商品金额
	*/ 
	public void setGoodPrice(BigDecimal goodPrice){ this.goodPrice=goodPrice ; } 
 	/** 
	* 获取 支付金额
	*/ 
	public BigDecimal getPayPrice(){ return payPrice ; } 
	/** 
	* 设置 支付金额
	*/ 
	public void setPayPrice(BigDecimal payPrice){ this.payPrice=payPrice ; } 
 	/** 
	* 获取 商品状态(10 已上架 20 已下架 ) 
	*/ 
	public Boolean getGoodStatus(){ return goodStatus ; } 
	/** 
	* 设置 商品状态(10 已上架 20 已下架 ) 
	*/ 
	public void setGoodStatus(Boolean goodStatus){ this.goodStatus=goodStatus ; } 
 	/** 
	* 获取 创建时间
	*/ 
	public Date getCreateTime(){ return createTime ; } 
	/** 
	* 设置 创建时间
	*/ 
	public void setCreateTime(Date createTime){ this.createTime=createTime ; } 


} 