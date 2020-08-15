package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.Varieties;


@Repository
public interface IVarietiesDao extends MyDao<Varieties>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<Varieties> queryPage(Criteria<Varieties> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<Varieties> queryList(Criteria<Varieties> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<Varieties> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	Varieties queryEntityById(String varietiesId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(Varieties record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<Varieties> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<Varieties> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<Varieties> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<Varieties> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String varietiesId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<Varieties> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
