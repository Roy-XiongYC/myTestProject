package com.xiongyc.product.service.impl;


import java.util.List;
import com.xiongyc.utils.code.AppResponseCode;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.product.bean.ShopOrder;
import com.xiongyc.product.service.IShopOrderService;


import com.xiongyc.product.dao.IShopOrderDao;


@Service
@Transactional
public class ShopOrderServiceImpl implements IShopOrderService{

@Override
  public PageInfo<ShopOrder> queryPage(Criteria<ShopOrder> param){
    PageHelper.startPage(param.getPageNum(), param.getPageSize());
    return  new PageInfo<ShopOrder>( shopOrderDao.queryPage(param));
  }

  public List<ShopOrder> queryList(Criteria<ShopOrder> param){
    return  shopOrderDao.queryList(param);
  }

@Override
  public Integer queryPageCount(Criteria<ShopOrder> param){
    return (Integer) shopOrderDao.queryPageCount(param);
  }

@Override
  public ShopOrder queryEntityById(String id){
    return shopOrderDao.queryEntityById(id);
  }

@Override
  public String insert(ShopOrder record){
    int result = shopOrderDao.insert(record);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertBatch(List<ShopOrder> list){
    int result = shopOrderDao.insertBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateByCriteria(Criteria<ShopOrder> param){
    int result = shopOrderDao.updateByCriteria(param);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String updateBatchByCriteria(List<ShopOrder> list){
    int result = shopOrderDao.updateBatchByCriteria(list);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String insertOrUpdateBatch(List<ShopOrder> list){
    int result = shopOrderDao.insertOrUpdateBatch(list);
    if ( result != list.size()) { 
      return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteById(String id){
    int result = shopOrderDao.deleteById(id);
    if ( result != 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteByCriteria(Criteria<ShopOrder> param){
    int result = shopOrderDao.deleteByCriteria(param);
    if ( result < 1) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Override
  public String deleteBatchByIds(String[] ids){
    int result = shopOrderDao.deleteBatchByIds(ids);
    if ( result == 0) { 
      return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();    } 
    return null;
  }

@Autowired
   private IShopOrderDao shopOrderDao;

}
