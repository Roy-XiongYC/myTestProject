package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.PetsClass;


public interface IPetsClassService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<PetsClass> queryPage(Criteria<PetsClass> param);

/**
* 查询集合 
* @param param
* @return
*/
List<PetsClass> queryList(Criteria<PetsClass> param);

/**
* 查询集合总记录数 
* @param param
* @return
*/
Integer queryPageCount(Criteria<PetsClass> param);

/**
* 查询实体 
* @param id
* @return
*/
PetsClass queryEntityById(String classId);

/**
* 新增实体 
* @param record
* @return
*/
String insert(PetsClass record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<PetsClass> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<PetsClass> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<PetsClass> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<PetsClass> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String classId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<PetsClass> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
