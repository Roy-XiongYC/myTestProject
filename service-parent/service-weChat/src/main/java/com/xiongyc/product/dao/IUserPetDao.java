package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.UserPet;


@Repository
public interface IUserPetDao extends MyDao<UserPet>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<UserPet> queryPage(Criteria<UserPet> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<UserPet> queryList(Criteria<UserPet> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<UserPet> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	UserPet queryEntityById(String petD);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(UserPet record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<UserPet> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<UserPet> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<UserPet> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<UserPet> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String petD);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<UserPet> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
