package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.PetsClass;
import com.xiongyc.product.service.IPetsClassService;


import com.xiongyc.product.dao.IPetsClassDao;


@Service
@Transactional
public class PetsClassServiceImpl implements IPetsClassService{

@Override
  public PageInfo<PetsClass> queryPage(Criteria<PetsClass> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<PetsClass>( petsClassDao.queryPage(param));
  }

  public List<PetsClass> queryList(Criteria<PetsClass> param){
    return  petsClassDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<PetsClass> param){
    return (Integer) petsClassDao.queryPageCount(param);
  }

@Override
  public PetsClass queryEntityById(String id){
    return petsClassDao.queryEntityById(id);
  }

@Override
  public String insert(PetsClass record){
    int result = petsClassDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<PetsClass> list){
    int result = petsClassDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<PetsClass> param){
    int result = petsClassDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<PetsClass> list){
    int result = petsClassDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<PetsClass> list){
    int result = petsClassDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = petsClassDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<PetsClass> param){
    int result = petsClassDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = petsClassDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IPetsClassDao petsClassDao;

}
