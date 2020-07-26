package com.xiongyc.product.dao;

import java.util.List;

import com.xiongyc.product.bean.SysGroup;
import com.xiongyc.utils.mybatis.Criteria;

public interface ISysGroupDao {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysGroup> queryPage(Criteria<SysGroup> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysGroup> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysGroup queryEntityById(String groupId);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	Integer insert(SysGroup record);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	Integer updateByCriteria(Criteria<SysGroup> param);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteById(String groupId);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteByCriteria(Criteria<SysGroup> param);

	static final String MAPPER_NAMESPACE = "com.person.web.admin.repository.SysGroupMapper";

}
