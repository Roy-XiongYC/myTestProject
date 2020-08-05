package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.ShopGood;
import com.xiongyc.product.service.IShopGoodService;


import com.xiongyc.product.dao.IShopGoodDao;


@Service
@Transactional
public class ShopGoodServiceImpl implements IShopGoodService{

@Override
  public PageInfo<ShopGood> queryPage(Criteria<ShopGood> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<ShopGood>( shopGoodDao.queryPage(param));
  }

  public List<ShopGood> queryList(Criteria<ShopGood> param){
    return  shopGoodDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<ShopGood> param){
    return (Integer) shopGoodDao.queryPageCount(param);
  }

@Override
  public ShopGood queryEntityById(String id){
    return shopGoodDao.queryEntityById(id);
  }

@Override
  public String insert(ShopGood record){
    int result = shopGoodDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<ShopGood> list){
    int result = shopGoodDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<ShopGood> param){
    int result = shopGoodDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<ShopGood> list){
    int result = shopGoodDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<ShopGood> list){
    int result = shopGoodDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = shopGoodDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<ShopGood> param){
    int result = shopGoodDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = shopGoodDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IShopGoodDao shopGoodDao;

}
