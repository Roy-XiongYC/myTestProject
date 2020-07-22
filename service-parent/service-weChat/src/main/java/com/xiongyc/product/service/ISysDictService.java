package com.xiongyc.product.service;

import java.util.List;
import java.util.Map;

import com.xiongyc.product.bean.SysDict;
import com.xiongyc.utils.mybatis.Criteria;


public interface ISysDictService {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysDict> queryPage(Criteria<SysDict> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysDict> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysDict queryEntityById(String id);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	String insert(SysDict record);
	String insertOrUpdate(SysDict record);
	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	String updateByCriteria(Criteria<SysDict> param);

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
	String deleteByCriteria(Criteria<SysDict> param);
	
	/**
	 * 数据字典翻译 ，转换为 List <Map> 形式
	 * 
	 * @param data
	 *            原始结果集 T为pojo对像，需要在翻译字段上加注解 Dict
	 * 
	 * @return 翻译后结果集
	 * 
	 * @see com.person.framework.annotation.Dict
	 */
	<T> List<Map<String, Object>> translateToMapList(List<T> data);

	
	/**
	 * 数据字典翻译 ，转换为 Map 形式
	 * 
	 * @param data
	 *            pojo对像，需要在翻译字段上加注解 Dict
	 * 
	 * @return 翻译后结果
	 * 
	 * @see com.person.framework.annotation.Dict
	 */
	Map<String, Object> translateToMap(Object obj);

	List<Map<String, Object>> queryPageList(Criteria<SysDict> param);

}
