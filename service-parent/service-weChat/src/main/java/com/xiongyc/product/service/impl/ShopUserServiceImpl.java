package com.xiongyc.product.service.impl;

import java.util.Date;
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
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.product.dao.IShopUserDao;
import com.xiongyc.product.result.WxResult;

@Service
@Transactional
public class ShopUserServiceImpl implements IShopUserService {

	@Override
	public PageInfo<ShopUser> queryPage(Criteria<ShopUser> param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		return new PageInfo<ShopUser>(shopUserDao.queryPage(param));
	}

	public List<ShopUser> queryList(Criteria<ShopUser> param) {
		return shopUserDao.queryList(param);
	}

	@Override
	public Integer queryPageCount(Criteria<ShopUser> param) {
		return (Integer) shopUserDao.queryPageCount(param);
	}

	@Override
	public ShopUser queryEntityById(String id) {
		return shopUserDao.queryEntityById(id);
	}

	@Override
	public String insert(ShopUser record) {
		int result = shopUserDao.insert(record);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String insertBatch(List<ShopUser> list) {
		int result = shopUserDao.insertBatch(list);
		if (result != list.size()) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String updateByCriteria(Criteria<ShopUser> param) {
		int result = shopUserDao.updateByCriteria(param);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String updateBatchByCriteria(List<ShopUser> list) {
		int result = shopUserDao.updateBatchByCriteria(list);
		if (result == 0) {
			return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String insertOrUpdateBatch(List<ShopUser> list) {
		int result = shopUserDao.insertOrUpdateBatch(list);
		if (result != list.size()) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteById(String id) {
		int result = shopUserDao.deleteById(id);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteByCriteria(Criteria<ShopUser> param) {
		int result = shopUserDao.deleteByCriteria(param);
		if (result < 1) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteBatchByIds(String[] ids) {
		int result = shopUserDao.deleteBatchByIds(ids);
		if (result == 0) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public ShopUser saveUser(WxResult accessToken) {
		ShopUser user = shopUserDao.queryEntityByUnionId(accessToken.getOpenid());
		if(user == null) {
			user = new ShopUser();
			user.setUserId(sequenceService.getUpdateQuerySeq("TSU", "t_shop_user"));
			user.setCity(accessToken.getCity());
			user.setCountry(accessToken.getCountry());
			user.setCreateTime(new Date());
			user.setHeadimgurl(accessToken.getHeadimgurl());
			user.setIntegral(0);
//			user.setMobile(accessToken.get);
			user.setNickName(accessToken.getNickname());
			user.setProvince(accessToken.getProvince());
			user.setPwd("8888");
			user.setSex(accessToken.getSex());
			//user.setUnionId(accessToken.getUnionid());
			user.setUnionId(accessToken.getOpenid());
			shopUserDao.insert(user);
			
		}
		return user;
	}

	
	@Autowired
	private IShopUserDao shopUserDao;
	
	@Autowired
	private SequenceService sequenceService;

}
