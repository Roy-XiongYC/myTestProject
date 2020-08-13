package com.xiongyc.product.service;


import java.util.List;
import com.xiongyc.utils.mybatis.Criteria;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.UserPet;


public interface IUserPetService{

/**
* 查询集合 
* @param param
* @return
*/
PageInfo<UserPet> queryPage(Criteria<UserPet> param);

/**
* 查询集合 
* @param param
* @return
*/
List<UserPet> queryList(Criteria<UserPet> param);

/**
* 查询集合总记录数 
* @param param
* @return
*/
Integer queryPageCount(Criteria<UserPet> param);

/**
* 查询实体 
* @param id
* @return
*/
UserPet queryEntityById(String petD);

/**
* 新增实体 
* @param record
* @return
*/
String insert(UserPet record);

/**
* 批量新增实体 
* @param list
* @return
*/
String insertBatch(List<UserPet> list);

/**
* 更新实体 
* @param param
* @return
*/
String updateByCriteria(Criteria<UserPet> param);

/**
* 批量更新实体 
* @param param
* @return
*/
String updateBatchByCriteria(List<UserPet> list);

/**
* 批量保存实体 
* @param list
* @return
*/
String insertOrUpdateBatch(List<UserPet> list);

/**
* 删除实体 
* @param id
* @return
*/
String deleteById(String petD);

/**
* 删除实体 
* @param model
* @return
*/
String deleteByCriteria(Criteria<UserPet> param);

/**
* 批量删除实体 
* @param ids
* @return
*/
String deleteBatchByIds(String[] ids);



}
