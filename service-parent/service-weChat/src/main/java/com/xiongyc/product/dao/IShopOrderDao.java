package com.xiongyc.product.dao;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import org.springframework.stereotype.Repository;
import com.xiongyc.utils.mybatis.MyDao;
import com.xiongyc.product.bean.ShopOrder;


@Repository
public interface IShopOrderDao extends MyDao<ShopOrder>{

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopOrder> queryPage(Criteria<ShopOrder> param);

	/**
	* 查询集合 
	* @param param
	* @return
	*/
	List<ShopOrder> queryList(Criteria<ShopOrder> param);

	/**
	* 查询集合总记录数 
	* @param param
	* @return
	*/
	Integer queryPageCount(Criteria<ShopOrder> param);

	/**
	* 查询实体 
	* @param id
	* @return
	*/
	ShopOrder queryEntityById(String orderId);

	/**
	* 新增实体 
	* @param record
	* @return
	*/
	int insert(ShopOrder record);

	/**
	* 批量新增实体 
	* @param list
	* @return
	*/
	Integer insertBatch(List<ShopOrder> list);

	/**
	* 更新实体 
	* @param param
	* @return
	*/
	Integer updateByCriteria(Criteria<ShopOrder> param);

	/**
	* 批量更新实体 
	* @param list
	* @return
	*/
	Integer updateBatchByCriteria(List<ShopOrder> list);

	/**
	* 批量保存实体 
	* @param list
	* @return
	*/
	Integer insertOrUpdateBatch(List<ShopOrder> list);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteById(String orderId);

	/**
	* 删除实体 
	* @param id
	* @return
	*/
	Integer deleteByCriteria(Criteria<ShopOrder> param);

	/**
	* 删除实体 
	* @param ids
	* @return
	*/
	Integer deleteBatchByIds(String[] array);



}
