package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.Varieties;
import com.xiongyc.product.service.IVarietiesService;


import com.xiongyc.product.dao.IVarietiesDao;


@Service
@Transactional
public class VarietiesServiceImpl implements IVarietiesService{

@Override
  public PageInfo<Varieties> queryPage(Criteria<Varieties> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<Varieties>( varietiesDao.queryPage(param));
  }

  public List<Varieties> queryList(Criteria<Varieties> param){
    return  varietiesDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<Varieties> param){
    return (Integer) varietiesDao.queryPageCount(param);
  }

@Override
  public Varieties queryEntityById(String id){
    return varietiesDao.queryEntityById(id);
  }

@Override
  public String insert(Varieties record){
    int result = varietiesDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<Varieties> list){
    int result = varietiesDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<Varieties> param){
    int result = varietiesDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<Varieties> list){
    int result = varietiesDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<Varieties> list){
    int result = varietiesDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = varietiesDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<Varieties> param){
    int result = varietiesDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = varietiesDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IVarietiesDao varietiesDao;

}
