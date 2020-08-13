package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.SysDict;


@Repository
public interface ISysDictDao extends MyDao<SysDict>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<SysDict> queryPage(Criteria<SysDict> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<SysDict> queryList(Criteria<SysDict> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<SysDict> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	SysDict queryEntityById(String dictId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(SysDict record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<SysDict> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<SysDict> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<SysDict> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<SysDict> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String dictId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<SysDict> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
