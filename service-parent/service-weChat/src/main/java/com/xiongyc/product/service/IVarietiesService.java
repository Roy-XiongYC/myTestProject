package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.Varieties;


public interface IVarietiesService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<Varieties> queryPage(Criteria<Varieties> param);

/**
* 查询集合 
* @param param
* @return
*/
List<Varieties> queryList(Criteria<Varieties> param);

/**
* 查询集合总记录数 
* @param param
* @return
*/
Integer queryPageCount(Criteria<Varieties> param);

/**
* 查询实体 
* @param id
* @return
*/
Varieties queryEntityById(String varietiesId);

/**
* 新增实体 
* @param record
* @return
*/
String insert(Varieties record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<Varieties> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<Varieties> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<Varieties> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<Varieties> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String varietiesId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<Varieties> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
