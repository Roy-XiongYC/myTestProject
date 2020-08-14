package com.xiongyc.product.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.xiongyc.utils.mybatis.IModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel("商城订单表")
public class ShopOrder implements IModel {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号")
	private String orderId;

	@ApiModelProperty(value = "")
	private String orderType;

	/**
	 * 用户编号
	 */
	@ApiModelProperty(value = "用户编号")
	private String userId;

	/**
	 * 用户名称
	 */
	@ApiModelProperty(value = "用户名称")
	private String userName;

	/**
	 * 联系方式手机号
	 */
	@ApiModelProperty(value = "联系方式手机号")
	private String mobile;

	/**
	 * 订单商品json
	 */
	@ApiModelProperty(value = "订单商品json ")
	private String goodsInfo;

	/**
	 * 支付金额
	 */
	@ApiModelProperty(value = "支付金额")
	private BigDecimal payPrice;

	/**
	 * 订单金额
	 */
	@ApiModelProperty(value = "订单金额")
	private BigDecimal orderPrice;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 10 待付款 20 待收货 30 已完成 40 已取消
	 */
	@ApiModelProperty(value = "10 待付款 20 待收货 30 已完成 40 已取消")
	private Boolean orderStatus;

	/**
	 * 订单时间
	 */
	@ApiModelProperty(value = "订单时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date createTime;

	/**
	 * 获取 订单编号
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置 订单编号
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * 获取 用户编号
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置 用户编号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取 联系方式手机号
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置 联系方式手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取 订单商品json
	 */
	public String getGoodsInfo() {
		return goodsInfo;
	}

	/**
	 * 设置 订单商品json
	 */
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	/**
	 * 获取 支付金额
	 */
	public BigDecimal getPayPrice() {
		return payPrice;
	}

	/**
	 * 设置 支付金额
	 */
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	/**
	 * 获取 订单金额
	 */
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	/**
	 * 设置 订单金额
	 */
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * 获取 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取 10 待付款 20 待收货 30 已完成 40 已取消
	 */
	public Boolean getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 设置 10 待付款 20 待收货 30 已完成 40 已取消
	 */
	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 获取 订单时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 订单时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}