package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.ShopUser;
import com.xiongyc.product.service.IShopUserService;


import com.xiongyc.product.dao.IShopUserDao;


@Service
@Transactional
public class ShopUserServiceImpl implements IShopUserService{

@Override
  public PageInfo<ShopUser> queryPage(Criteria<ShopUser> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<ShopUser>( shopUserDao.queryPage(param));
  }

  public List<ShopUser> queryList(Criteria<ShopUser> param){
    return  shopUserDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<ShopUser> param){
    return (Integer) shopUserDao.queryPageCount(param);
  }

@Override
  public ShopUser queryEntityById(String id){
    return shopUserDao.queryEntityById(id);
  }

@Override
  public String insert(ShopUser record){
    int result = shopUserDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<ShopUser> list){
    int result = shopUserDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<ShopUser> param){
    int result = shopUserDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<ShopUser> list){
    int result = shopUserDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<ShopUser> list){
    int result = shopUserDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = shopUserDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<ShopUser> param){
    int result = shopUserDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = shopUserDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IShopUserDao shopUserDao;

}
