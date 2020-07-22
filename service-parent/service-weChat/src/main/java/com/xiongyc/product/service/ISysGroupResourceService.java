package com.xiongyc.product.service;

import java.util.List;

import com.xiongyc.product.bean.SysGroupResource;
import com.xiongyc.utils.mybatis.Criteria;

public interface ISysGroupResourceService {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysGroupResource> queryPage(Criteria<SysGroupResource> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysGroupResource> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysGroupResource queryEntityById(String id);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	String insert(SysGroupResource record);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	String updateByCriteria(Criteria<SysGroupResource> param);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String id);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	String deleteByCriteria(Criteria<SysGroupResource> param);

	/**
	 * 配置权限使用
	 */
	void insertResource(String groupId, String resource, String userId);

	String insertList(List<SysGroupResource> list);

}
