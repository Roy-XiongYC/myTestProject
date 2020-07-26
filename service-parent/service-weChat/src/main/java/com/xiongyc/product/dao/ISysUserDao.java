package com.xiongyc.product.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiongyc.product.bean.SysUser;
import com.xiongyc.utils.mybatis.Criteria;

@Repository
public interface ISysUserDao {

	/**
	 * 鏌ヨ闆嗗悎
	 * 
	 * @param param
	 * @return
	 */
	List<SysUser> queryPage(Criteria<SysUser> param);

	/**
	 * 鏌ヨ闆嗗悎鎬昏褰曟暟
	 * 
	 * @param param
	 * @return
	 */
	Integer queryPageCount(Criteria<SysUser> param);

	/**
	 * 鏌ヨ瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	SysUser queryEntityById(String userId);

	/**
	 * 鏂板瀹炰綋
	 * 
	 * @param record
	 * @return
	 */
	Integer insert(SysUser record);

	/**
	 * 鏇存柊瀹炰綋
	 * 
	 * @param param
	 * @return
	 */
	Integer updateByCriteria(Criteria<SysUser> param);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteById(String userId);

	/**
	 * 鍒犻櫎瀹炰綋
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteByCriteria(Criteria<SysUser> param);

	int changePassword(String userId, String newPassword, Date passwordExpDate);

}
