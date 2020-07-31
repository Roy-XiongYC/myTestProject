package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.PetsClass;


@Repository
public interface IPetsClassDao extends MyDao<PetsClass>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<PetsClass> queryPage(Criteria<PetsClass> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<PetsClass> queryList(Criteria<PetsClass> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<PetsClass> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	PetsClass queryEntityById(String classId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(PetsClass record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<PetsClass> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<PetsClass> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<PetsClass> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<PetsClass> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String classId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<PetsClass> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
