package com.xiongyc.dao;


import org.springframework.stereotype.Repository;


@Repository
public interface ISysUserDao{

//	/**
//	* 查询集合 
//	* @param param
//	* @return
//	*/
//	List<SysUser> queryPage(Pagination page , Criteria<SysUser> param);
//
//	/**
//	* 查询集合总记录数 
//	* @param param
//	* @return
//	*/
//	Integer queryPageCount(Pagination page , Criteria<SysUser> param);
//
//	/**
//	* 查询实体 
//	* @param id
//	* @return
//	*/
//	SysUser queryEntityById(String uSERID);
//
//	/**
//	* 新增实体 
//	* @param record
//	* @return
//	*/
//	Integer insert(SysUser record);
//
//	/**
//	* 批量新增实体 
//	* @param list
//	* @return
//	*/
//	Integer insertBatch(List<SysUser> list);
//
//	/**
//	* 更新实体 
//	* @param param
//	* @return
//	*/
//	Integer updateByCriteria(Criteria<SysUser> param);
//
//	/**
//	* 批量更新实体 
//	* @param list
//	* @return
//	*/
//	Integer updateBatchByCriteria(List<SysUser> list);
//
//	/**
//	* 批量保存实体 
//	* @param list
//	* @return
//	*/
//	Integer insertOrUpdateBatch(List<SysUser> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String uSERID);

//	/**
//	* 删除实体 
//	* @param id
//	* @return
//	*/
//	Integer deleteByCriteria(Criteria<SysUser> param);
//
//	/**
//	* 删除实体 
//	* @param ids
//	* @return
//	*/
//	Integer deleteBatchByIds(String[] array);
//


}
