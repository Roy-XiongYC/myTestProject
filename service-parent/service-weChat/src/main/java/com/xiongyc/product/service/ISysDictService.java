package com.xiongyc.product.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.SysDict;
import com.xiongyc.utils.mybatis.Criteria;

public interface ISysDictService {

	/**
	 * 查询集合
	 * 
	 * @param param
	 * @return
	 */
	PageInfo<SysDict> queryPage(Criteria<SysDict> param);

	/**
	 * 查询集合
	 * 
	 * @param param
	 * @return
	 */
	List<SysDict> queryList(Criteria<SysDict> param);

	/**
	 * 查询集合总记录数
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysDict> param);

	/**
	 * 查询实体
	 * 
	 * @param id
	 * @return
	 */
	SysDict queryEntityById(String dictId);

	/**
	 * 新增实体
	 * 
	 * @param record
	 * @return
	 */
	String insert(SysDict record);

	/**
	 * 批量新增实体
	 * 
	 * @param list
	 * @return
	 */
	String insertBatch(List<SysDict> list);

	/**
	 * 更新实体
	 * 
	 * @param param
	 * @return
	 */
	String updateByCriteria(Criteria<SysDict> param);

	/**
	 * 批量更新实体
	 * 
	 * @param param
	 * @return
	 */
	String updateBatchByCriteria(List<SysDict> list);

	/**
	 * 批量保存实体
	 * 
	 * @param list
	 * @return
	 */
	String insertOrUpdateBatch(List<SysDict> list);

	/**
	 * 删除实体
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String dictId);

	/**
	 * 删除实体
	 * 
	 * @param model
	 * @return
	 */
	String deleteByCriteria(Criteria<SysDict> param);

	/**
	 * 批量删除实体
	 * 
	 * @param ids
	 * @return
	 */
	String deleteBatchByIds(String[] ids);

	/**
	 * 数据字典翻译 ，转换为 List <Map> 形式
	 * 
	 * @param data 原始结果集 T为pojo对像，需要在翻译字段上加注解 Dict
	 * 
	 * @return 翻译后结果集
	 * 
	 * @see com.glz.cloud.utils.Dict
	 */
	<T> List<Map<String, Object>> translateToMapList(List<T> data);

	/**
	 * 数据字典翻译 ，转换为 List <Map> 形式
	 * 
	 * @param data         原始结果集 columnName = value
	 * @param transColumns 需要翻译的字段 columnName = dictCode
	 * @return 翻译后结果集
	 */
	List<Map<String, Object>> translateToMapList(List<Map<String, Object>> data, Map<String, String> transColumns);

	/**
	 * 数据字典翻译 ，转换为 Map 形式
	 * 
	 * @param data pojo对像，需要在翻译字段上加注解 Dict
	 * 
	 * @return 翻译后结果
	 * 
	 * @see com.glz.cloud.utils.Dict
	 */
	Map<String, Object> translateToMap(Object obj);

	Map<String, List<SysDict>> queryEntityByDictCode(String... dictCode);

}
