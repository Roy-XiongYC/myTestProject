package com.xiongyc.product.result;

import java.io.Serializable;
import java.util.List;
/**
 * jquery datatables 返回格式
 * @author wangy
 *
 */
public class PageResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 页面传入参数， 原值传回
	 */
	private String sEcho;
	/**
	 * 过滤后总记录数
	 */
	private Integer iTotalDisplayRecords;
	/**
	 * 过滤前总记录数
	 */
	private Integer iTotalRecords;
	/**
	 *  要以JSON格式返回
	 */
	private List<?> aaData;
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<?> getAaData() {
		return aaData;
	}
	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}
	
	
}
