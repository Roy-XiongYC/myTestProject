package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.ShopUser;


public interface IShopUserService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<ShopUser> queryPage(Criteria<ShopUser> param);

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
String insert(ShopUser record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<ShopUser> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<ShopUser> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<ShopUser> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<ShopUser> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String userId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<ShopUser> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
