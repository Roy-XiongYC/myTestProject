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
import com.xiongyc.product.bean.SysTest;
import com.xiongyc.product.service.ISysTestService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "")
@RequestMapping(value = "/sysTest")
public class SysTestController {

	@Autowired
	private ISysTestService sysTestService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<SysTest>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<SysTest> param = new Criteria<SysTest>(pageNum,pageSize);

		if (!StringUtils.isEmpty(id)) {
			param.addParam("id", id);
		}
		param.setOrderBy("id desc");
		
		return AppResponseCode.success(sysTestService.queryPage(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody SysTest sysTest) {
		String ret = null;
		if (!StringUtils.isEmpty(sysTest.getId())) {
			Criteria<SysTest> param = new Criteria<SysTest>();
			param.addParam("id", sysTest.getId());
			param.setRecord(sysTest);
			ret = sysTestService.updateByCriteria(param);
		} else {
			sysTest.setId(sequenceService.getUpdateQuerySeq("ST", "sys_test"));
			ret = sysTestService.insert(sysTest);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<SysTest> list) {
		for (SysTest sysTest : list) {
			sysTest.setId(sequenceService.getUpdateQuerySeq("ST", "sys_test"));
		}
		return sysTestService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<SysTest> list) {
		return sysTestService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<SysTest> list) {
		return sysTestService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById")
	public JsonResult<SysTest> queryEntityById(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		return AppResponseCode.success(sysTestService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return sysTestService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<SysTest> param = new Criteria<SysTest>();
		param.addParam("id", id);
		// TODO Auto-generated method stub
		return sysTestService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return sysTestService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

}