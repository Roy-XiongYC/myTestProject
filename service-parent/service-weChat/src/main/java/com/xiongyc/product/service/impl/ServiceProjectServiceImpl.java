package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.ServiceProject;
import com.xiongyc.product.service.IServiceProjectService;


import com.xiongyc.product.dao.IServiceProjectDao;


@Service
@Transactional
public class ServiceProjectServiceImpl implements IServiceProjectService{

@Override
  public PageInfo<ServiceProject> queryPage(Criteria<ServiceProject> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<ServiceProject>( serviceProjectDao.queryPage(param));
  }

  public List<ServiceProject> queryList(Criteria<ServiceProject> param){
    return  serviceProjectDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<ServiceProject> param){
    return (Integer) serviceProjectDao.queryPageCount(param);
  }

@Override
  public ServiceProject queryEntityById(String id){
    return serviceProjectDao.queryEntityById(id);
  }

@Override
  public String insert(ServiceProject record){
    int result = serviceProjectDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<ServiceProject> list){
    int result = serviceProjectDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<ServiceProject> param){
    int result = serviceProjectDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<ServiceProject> list){
    int result = serviceProjectDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<ServiceProject> list){
    int result = serviceProjectDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = serviceProjectDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<ServiceProject> param){
    int result = serviceProjectDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = serviceProjectDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IServiceProjectDao serviceProjectDao;

}
