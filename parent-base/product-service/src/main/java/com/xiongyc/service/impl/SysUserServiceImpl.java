package com.xiongyc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiongyc.dao.ISysUserDao;
import com.xiongyc.service.ISysUserService;
import com.xiongyc.utils.code.AppResponseCode;

@Service
@Transactional
public class SysUserServiceImpl implements ISysUserService {

//@Override
//  public Page<SysUser> queryPage(Page<SysUser> page,Criteria<SysUser> param){
//    page.setRecords( sysUserDao.queryPage(page,param));
//    return page;
//  }
//
//@Override
//  public Integer queryPageCount(Page<SysUser> page,Criteria<SysUser> param){
//    return (Integer) sysUserDao.queryPageCount(page,param);
//  }
//
//@Override
//  public SysUser queryEntityById(String id){
//    return sysUserDao.queryEntityById(id);
//  }
//
//@Override
//  public String insert(SysUser record){
//    int result = sysUserDao.insert(record);
//    if ( result != 1) { 
//      return AppResponseCode.RESPONSE_CODE_USER_INSERT_FALSE.getMessage();    } 
//    return null;
//  }
//
//@Override
//  public String insertBatch(List<SysUser> list){
//    int result = sysUserDao.insertBatch(list);
//    if ( result != list.size()) { 
//      return AppResponseCode.RESPONSE_CODE_USER_INSERT_FALSE.getMessage();    } 
//    return null;
//  }
//
//@Override
//  public String updateByCriteria(Criteria<SysUser> param){
//    int result = sysUserDao.updateByCriteria(param);
//    if ( result != 1) { 
//      return AppResponseCode.RESPONSE_CODE_USER_UPDATE_FALSE.getMessage();    } 
//    return null;
//  }
//
//@Override
//  public String updateBatchByCriteria(List<SysUser> list){
//    int result = sysUserDao.updateBatchByCriteria(list);
//    if ( result == 0) { 
//      return AppResponseCode.RESPONSE_CODE_USER_UPDATE_FALSE.getMessage();    } 
//    return null;
//  }
//
//@Override
//  public String insertOrUpdateBatch(List<SysUser> list){
//    int result = sysUserDao.insertOrUpdateBatch(list);
//    if ( result != list.size()) { 
//      return AppResponseCode.RESPONSE_CODE_USER_INSERT_FALSE.getMessage();    } 
//    return null;
//  }

	@Override
	public String deleteById(String id) {
		int result = sysUserDao.deleteById(id);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

//@Override
//  public String deleteByCriteria(Criteria<SysUser> param){
//    int result = sysUserDao.deleteByCriteria(param);
//    if ( result < 1) { 
//      return AppResponseCode.RESPONSE_CODE_USER_DEL_FALSE.getMessage();    } 
//    return null;
//  }
//
//@Override
//  public String deleteBatchByIds(String[] ids){
//    int result = sysUserDao.deleteBatchByIds(ids);
//    if ( result == 0) { 
//      return AppResponseCode.RESPONSE_CODE_USER_DEL_FALSE.getMessage();    } 
//    return null;
//  }

	@Autowired
	private ISysUserDao sysUserDao;

}
