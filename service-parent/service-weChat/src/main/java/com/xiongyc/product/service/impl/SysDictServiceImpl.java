package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.SysDict;
import com.xiongyc.product.service.ISysDictService;


import com.xiongyc.product.dao.ISysDictDao;


@Service
@Transactional
public class SysDictServiceImpl implements ISysDictService{

@Override
  public PageInfo<SysDict> queryPage(Criteria<SysDict> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<SysDict>( sysDictDao.queryPage(param));
  }

  public List<SysDict> queryList(Criteria<SysDict> param){
    return  sysDictDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<SysDict> param){
    return (Integer) sysDictDao.queryPageCount(param);
  }

@Override
  public SysDict queryEntityById(String id){
    return sysDictDao.queryEntityById(id);
  }

@Override
  public String insert(SysDict record){
    int result = sysDictDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<SysDict> list){
    int result = sysDictDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<SysDict> param){
    int result = sysDictDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<SysDict> list){
    int result = sysDictDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<SysDict> list){
    int result = sysDictDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = sysDictDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<SysDict> param){
    int result = sysDictDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = sysDictDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private ISysDictDao sysDictDao;

}
