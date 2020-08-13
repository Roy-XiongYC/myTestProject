package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.ShopGood;


public interface IShopGoodService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<ShopGood> queryPage(Criteria<ShopGood> param);

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
String insert(ShopGood record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<ShopGood> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<ShopGood> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<ShopGood> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<ShopGood> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String goodId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<ShopGood> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
