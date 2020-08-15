package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.ServiceProject;


public interface IServiceProjectService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<ServiceProject> queryPage(Criteria<ServiceProject> param);

/**
* 查询集合 
* @param param
* @return
*/
List<ServiceProject> queryList(Criteria<ServiceProject> param);

/**
* 查询集合总记录数 
* @param param
* @return
*/
Integer queryPageCount(Criteria<ServiceProject> param);

/**
* 查询实体 
* @param id
* @return
*/
ServiceProject queryEntityById(String serviceId);

/**
* 新增实体 
* @param record
* @return
*/
String insert(ServiceProject record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<ServiceProject> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<ServiceProject> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<ServiceProject> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<ServiceProject> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String serviceId);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<ServiceProject> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
