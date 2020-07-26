package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.ShopUser;


@Repository
public interface IShopUserDao extends MyDao<ShopUser>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopUser> queryPage(Criteria<ShopUser> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopUser> queryList(Criteria<ShopUser> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<ShopUser> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	ShopUser queryEntityById(String userId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(ShopUser record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<ShopUser> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<ShopUser> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<ShopUser> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<ShopUser> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String userId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<ShopUser> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
