package com.xiongyc.product.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.SysTest;
import com.xiongyc.utils.mybatis.Criteria;


public interface ISysTestService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<SysTest> queryPage(Criteria<SysTest> param);
//
///**
//* 查询集合总记录数 
//* @param param
//* @return
//*/
//Integer queryPageCount(Page<SysTest> page , Criteria<SysTest> param);

/**
* 查询实体 
* @param id
* @return
*/
SysTest queryEntityById(String id);

/**
* 新增实体 
* @param record
* @return
*/
String insert(SysTest record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<SysTest> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<SysTest> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<SysTest> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<SysTest> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String id);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<SysTest> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



PageInfo<SysTest> queryAll(Criteria<SysTest> param);



}
