package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.ShopGood;


@Repository
public interface IShopGoodDao extends MyDao<ShopGood>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopGood> queryPage(Criteria<ShopGood> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopGood> queryList(Criteria<ShopGood> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<ShopGood> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	ShopGood queryEntityById(String goodId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(ShopGood record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<ShopGood> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<ShopGood> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<ShopGood> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<ShopGood> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String goodId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<ShopGood> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
