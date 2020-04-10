package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.SysTest;
import com.xiongyc.product.service.ISysTestService;


import com.xiongyc.product.dao.ISysTestDao;


@Service
@Transactional
public class SysTestServiceImpl implements ISysTestService{

@Override
  public PageInfo<SysTest> queryPage(Criteria<SysTest> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<SysTest>( sysTestDao.queryPage(param));
  }

  public List<SysTest> queryList(Criteria<SysTest> param){
    return  sysTestDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<SysTest> param){
    return (Integer) sysTestDao.queryPageCount(param);
  }

@Override
  public SysTest queryEntityById(String id){
    return sysTestDao.queryEntityById(id);
  }

@Override
  public String insert(SysTest record){
    int result = sysTestDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<SysTest> list){
    int result = sysTestDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<SysTest> param){
    int result = sysTestDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<SysTest> list){
    int result = sysTestDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<SysTest> list){
    int result = sysTestDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = sysTestDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<SysTest> param){
    int result = sysTestDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = sysTestDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private ISysTestDao sysTestDao;

}
