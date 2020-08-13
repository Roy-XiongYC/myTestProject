package com.xiongyc.product.controller;

import java.util.Date;
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
import com.xiongyc.product.bean.UserPet;
import com.xiongyc.product.service.IUserPetService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "用户宠物")
@RequestMapping(value = "/userPet")
public class UserPetController {

	@Autowired
	private IUserPetService userPetService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<UserPet>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<UserPet> param = new Criteria<UserPet>(pageNum, pageSize);
		if (!StringUtils.isEmpty(id)) {
			param.addParam("petId", id);
		}
		param.setOrderBy("pet_id desc");
		return AppResponseCode.success(userPetService.queryPage(param));
	}

	@ApiOperation(value = "查询列表")
	@GetMapping("/queryList")
	public JsonResult<List<UserPet>> queryList(
			@ApiParam(name = "userId", value = "主键ID") @RequestParam(required = false) String userId) {
		Criteria<UserPet> param = new Criteria<UserPet>();
		if (!StringUtils.isEmpty(userId)) {
			param.addParam("userId", userId);
		}
		param.setOrderBy("pet_id desc");
		return AppResponseCode.success(userPetService.queryList(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody UserPet userPet) {
		String ret = null;
		if (!StringUtils.isEmpty(userPet.getPetId())) {
			Criteria<UserPet> param = new Criteria<UserPet>();
			param.addParam("petId", userPet.getPetId());
			param.setRecord(userPet);
			ret = userPetService.updateByCriteria(param);
		} else {
			userPet.setPetId(sequenceService.getUpdateQuerySeq("TUP", "t_user_pet"));
			userPet.setCreateTime(new Date());
			ret = userPetService.insert(userPet);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<UserPet> list) {
		for (UserPet userPet : list) {
			userPet.setPetId(sequenceService.getUpdateQuerySeq("TUP", "t_user_pet"));
		}
		return userPetService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<UserPet> list) {
		return userPetService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<UserPet> list) {
		return userPetService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById")
	public JsonResult<UserPet> queryEntityById(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		return AppResponseCode.success(userPetService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return userPetService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<UserPet> param = new Criteria<UserPet>();
		param.addParam("petId", id);
		// TODO Auto-generated method stub
		return userPetService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return userPetService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

}