package com.xiongyc.product.bean;

import java.util.List;

import com.xiongyc.utils.mybatis.IModel;

/**
 * session 子model
 * @author wangy
 *
 */
public class SourceTree implements IModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String state;
	private String url;
	private String resourceTypeZh;
	private String resourceType;
	private String parentId;
	private String accessAuth;
	private String iconClass;
	
	private List<SourceTree> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public List<SourceTree> getChildren() {
		return children;
	}
	public void setChildren(List<SourceTree> children) {
		this.children = children;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getResourceTypeZh() {
		return resourceTypeZh;
	}
	public void setResourceTypeZh(String resourceTypeZh) {
		this.resourceTypeZh = resourceTypeZh;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getAccessAuth() {
		return accessAuth;
	}
	public void setAccessAuth(String accessAuth) {
		this.accessAuth = accessAuth;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public SourceTree() {
		super();
	}
	public SourceTree(String id, String text, String state, String url,
			List<SourceTree> children) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.url = url;
		this.children = children;
	}
	
}
