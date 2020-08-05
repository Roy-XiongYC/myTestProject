package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.ShopOrder;


public interface IShopOrderService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<ShopOrder> queryPage(Criteria<ShopOrder> param);

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
String insert(ShopOrder record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<ShopOrder> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<ShopOrder> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<ShopOrder> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<ShopOrder> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String orderId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<ShopOrder> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
