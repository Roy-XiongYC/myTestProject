package com.xiongyc.product.service;

import java.util.List;
import java.util.Map;

import com.xiongyc.product.bean.SysResource;
import com.xiongyc.product.bean.SysUser;
import com.xiongyc.utils.mybatis.Criteria;

public interface ISysResourceService {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysResource> queryPage(Criteria<SysResource> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysResource> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysResource queryEntityById(String resourceId);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	String insert(SysResource record);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	String updateByCriteria(Criteria<SysResource> param);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String resourceId);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	String deleteByCriteria(Criteria<SysResource> param);

	List<SysResource> queryAllByUser(SysUser sysUser);

	List<Map<String, Object>> queryPageList(Criteria<SysResource> param);
	/**
	 * 不分页
	 * @param param
	 * @return
	 */
	List<SysResource> queryAllPage(Criteria<SysResource> param);
	/**
	 * 查询所有菜单并对传入用户组验证是否有权限
	 * @param groupId
	 * @return
	 */
	List<SysResource> queryByGroup(Criteria<SysResource> param);
}
