package com.xiongyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.xiongyc.bean.SysUser;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.service.ISysUserService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "管理员表")
@RequestMapping(value = "/sysUser")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private SequenceService sequenceService;

//	@ApiOperation(value = "翻页查询列表")
//	@GetMapping("/queryPage")
//	public JsonResult<Page<SysUser>> queryPage(
//			@ApiParam(name = "currentPage", value = "页码") @RequestParam(name = "currentPage", required = false, defaultValue = "1") Integer currentPage,
//			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
//			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
//		Criteria<SysUser> param = new Criteria<SysUser>();
//		Page<SysUser> page = new Page<SysUser>(currentPage, pageSize);
//
//		if (!StringUtils.isEmpty(id)) {
//			param.addParam("uSERID", id);
//		}
//		param.setOrderBy("USER_ID desc");
//		return AppResponseCode.success(sysUserService.queryPage(page, param));
//	}
//
//	@ApiOperation(value = "保存数据")
//	@PostMapping("/addOrUpdate")
//	public JsonResult<Object> addOrUpdate(@RequestBody SysUser sysUser) {
//		String ret = null;
//		if (!StringUtils.isEmpty(sysUser.getUSERID())) {
//			Criteria<SysUser> param = new Criteria<SysUser>();
//			param.addParam("uSERID", sysUser.getUSERID());
//			param.setRecord(sysUser);
//			ret = sysUserService.updateByCriteria(param);
//		} else {
//			sysUser.setUSERID(sequenceService.getUpdateQuerySeq("SU", "sys_user"));
//			ret = sysUserService.insert(sysUser);
//		}
//		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
//	}
//
//	@ApiOperation(value = "批量新增数据")
//	@PostMapping("/addBatch")
//	public JsonResult<Object> addBatch(@RequestBody List<SysUser> list) {
//		for (SysUser sysUser : list) {
//			sysUser.setUSERID(sequenceService.getUpdateQuerySeq("SU", "sys_user"));
//		}
//		return sysUserService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
//	}
//
//	@ApiOperation(value = "批量更新数据")
//	@PostMapping("/updateBatchByCriteria")
//	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<SysUser> list) {
//		return sysUserService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
//				: AppResponseCode.failure();
//	}
//
//	@ApiOperation(value = " 批量保存实体")
//	@PostMapping("/insertOrUpdateBatch")
//	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<SysUser> list) {
//		return sysUserService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
//	}
//
//	@ApiOperation(value = "详情")
//	@GetMapping("/queryEntityById")
//	public JsonResult<SysUser> queryEntityById(
//			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
//		return AppResponseCode.success(sysUserService.queryEntityById(id));
//	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return sysUserService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}
//
//	@ApiOperation(value = "根据model删除")
//	@PostMapping("/deleteEntityByCriteria")
//	public JsonResult<Object> deleteEntityByCriteria(
//			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
//		Criteria<SysUser> param = new Criteria<SysUser>();
//		param.addParam("uSERID", id);
//		// TODO Auto-generated method stub
//		return sysUserService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
//	}
//
//	@ApiOperation(value = "根据主键批量删除")
//	@PostMapping("/deleteBatchByIds")
//	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
//		return sysUserService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
//	}

}