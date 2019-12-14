package com.xiongyc.product.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiongyc.product.bean.SysTest;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.mybatis.MyDao;


@Repository
public interface ISysTestDao extends MyDao<SysTest>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<SysTest> queryPage(Criteria<SysTest> param);
//
//	/**
//	* 查询集合总记录数 
//	* @param param
//	* @return
//	*/
//	Integer queryPageCount(Pagination page , Criteria<SysTest> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	SysTest queryEntityById(String id);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(SysTest record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<SysTest> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<SysTest> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<SysTest> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<SysTest> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String id);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<SysTest> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);

	List<SysTest> queryAll(Criteria<SysTest> param);



}
