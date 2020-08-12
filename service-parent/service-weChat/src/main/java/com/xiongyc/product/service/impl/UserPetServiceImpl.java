package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.UserPet;
import com.xiongyc.product.service.IUserPetService;


import com.xiongyc.product.dao.IUserPetDao;


@Service
@Transactional
public class UserPetServiceImpl implements IUserPetService{

@Override
  public PageInfo<UserPet> queryPage(Criteria<UserPet> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<UserPet>( userPetDao.queryPage(param));
  }

  public List<UserPet> queryList(Criteria<UserPet> param){
    return  userPetDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<UserPet> param){
    return (Integer) userPetDao.queryPageCount(param);
  }

@Override
  public UserPet queryEntityById(String id){
    return userPetDao.queryEntityById(id);
  }

@Override
  public String insert(UserPet record){
    int result = userPetDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<UserPet> list){
    int result = userPetDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<UserPet> param){
    int result = userPetDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<UserPet> list){
    int result = userPetDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<UserPet> list){
    int result = userPetDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = userPetDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<UserPet> param){
    int result = userPetDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = userPetDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IUserPetDao userPetDao;

}
