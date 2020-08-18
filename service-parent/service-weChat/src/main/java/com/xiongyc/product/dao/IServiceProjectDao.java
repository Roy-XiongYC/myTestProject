package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.ServiceProject;


@Repository
public interface IServiceProjectDao extends MyDao<ServiceProject>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ServiceProject> queryPage(Criteria<ServiceProject> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ServiceProject> queryList(Criteria<ServiceProject> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<ServiceProject> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	ServiceProject queryEntityById(String serviceId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(ServiceProject record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<ServiceProject> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<ServiceProject> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<ServiceProject> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<ServiceProject> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String serviceId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<ServiceProject> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
