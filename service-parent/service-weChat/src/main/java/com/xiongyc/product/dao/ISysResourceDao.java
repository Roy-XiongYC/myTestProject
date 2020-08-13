package com.xiongyc.product.dao;


import java.util.List;

import com.xiongyc.product.bean.SysResource;
import com.xiongyc.utils.mybatis.Criteria;


public interface ISysResourceDao{

	/**
	* 鏌ヨ闆嗗悎 
	* @param param
	* @return
	*/
	List<SysResource> queryPage(Criteria<SysResource> param);

	/**
	* 鏌ヨ闆嗗悎鎬昏褰曟暟 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<SysResource> param);

	/**
	* 鏌ヨ瀹炰綋 
	* @param id
	* @return
	*/
	SysResource queryEntityById(String resourceId);

	/**
	* 鏂板瀹炰綋 
	* @param record
	* @return
	*/
	Integer insert(SysResource record);

	/**
	* 鏇存柊瀹炰綋 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<SysResource> param);

	/**
	* 鍒犻櫎瀹炰綋 
	* @param id
	* @return
	*/
	Integer deleteById(String resourceId);

	/**
	* 鍒犻櫎瀹炰綋 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<SysResource> param);

	static final String MAPPER_NAMESPACE = "com.person.web.admin.repository.SysResourceMapper";

	List<SysResource> queryAllPage(Criteria<SysResource> param);
	/**
	 * 查询所有菜单并对传入用户组验证是否有权限
	 * @param groupId
	 * @return
	 */
	List<SysResource> queryByGroup(Criteria<SysResource> param);

	List<SysResource> queryPageNoLimit(Criteria<SysResource> param);


}
