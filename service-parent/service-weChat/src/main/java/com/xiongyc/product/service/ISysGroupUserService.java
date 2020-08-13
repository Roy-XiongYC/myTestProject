package com.xiongyc.product.service;

import java.util.List;

import com.xiongyc.product.bean.SysGroupUser;
import com.xiongyc.utils.mybatis.Criteria;

public interface ISysGroupUserService {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysGroupUser> queryPage(Criteria<SysGroupUser> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysGroupUser> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysGroupUser queryEntityById(String id);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	String insert(SysGroupUser record);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	String updateByCriteria(Criteria<SysGroupUser> param);

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
	String deleteByCriteria(Criteria<SysGroupUser> param);

}
