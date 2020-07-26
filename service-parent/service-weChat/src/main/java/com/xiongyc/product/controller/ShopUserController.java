package com.xiongyc.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.ShopUser;
import com.xiongyc.product.service.IShopUserService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "商城用户表")
@RequestMapping(value = "/shopUser")
public class ShopUserController {

	@Autowired
	private IShopUserService shopUserService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<ShopUser>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<ShopUser> param = new Criteria<ShopUser>(pageNum, pageSize);
		if (!StringUtils.isEmpty(id)) {
			param.addParam("userId", id);
		}
		param.setOrderBy("user_id desc");
		return AppResponseCode.success(shopUserService.queryPage(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody ShopUser shopUser) {
		String ret = null;
		if (!StringUtils.isEmpty(shopUser.getUserId())) {
			Criteria<ShopUser> param = new Criteria<ShopUser>();
			param.addParam("userId", shopUser.getUserId());
			param.setRecord(shopUser);
			ret = shopUserService.updateByCriteria(param);
		} else {
			shopUser.setUserId(sequenceService.getUpdateQuerySeq("TSU", "t_shop_user"));
			ret = shopUserService.insert(shopUser);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<ShopUser> list) {
		for (ShopUser shopUser : list) {
			shopUser.setUserId(sequenceService.getUpdateQuerySeq("TSU", "t_shop_user"));
		}
		return shopUserService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<ShopUser> list) {
		return shopUserService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<ShopUser> list) {
		return shopUserService.insertOrUpdateBatch(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById")
	public JsonResult<ShopUser> queryEntityById(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		return AppResponseCode.success(shopUserService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return shopUserService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<ShopUser> param = new Criteria<ShopUser>();
		param.addParam("userId", id);
		// TODO Auto-generated method stub
		return shopUserService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return shopUserService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

}