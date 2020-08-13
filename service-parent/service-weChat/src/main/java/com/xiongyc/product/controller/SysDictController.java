package com.xiongyc.product.controller;

import java.util.List;
import java.util.Map;

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
import com.xiongyc.product.bean.SysDict;
import com.xiongyc.product.service.ISysDictService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "字典表")
@RequestMapping(value = "/sysDict")
public class SysDictController {

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<SysDict>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<SysDict> param = new Criteria<SysDict>(pageNum, pageSize);
		if (!StringUtils.isEmpty(id)) {
			param.addParam("dictId", id);
		}
		param.setOrderBy("dict_id desc");
		return AppResponseCode.success(sysDictService.queryPage(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody SysDict sysDict) {
		String ret = null;
		if (!StringUtils.isEmpty(sysDict.getDictId())) {
			Criteria<SysDict> param = new Criteria<SysDict>();
			param.addParam("dictId", sysDict.getDictId());
			param.setRecord(sysDict);
			ret = sysDictService.updateByCriteria(param);
		} else {
			sysDict.setDictId(sequenceService.getUpdateQuerySeq("TSD", "t_sys_dict"));
			ret = sysDictService.insert(sysDict);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@GetMapping("/queryEntityByDictCode")
	public JsonResult<Map<String ,List<SysDict>>> queryEntityByDictCode(@ApiParam(name = "dictCode", value = "编码") @RequestParam(required = false) String... dictCode) {
		return AppResponseCode.success(sysDictService.queryEntityByDictCode(dictCode));
	}

	
	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<SysDict> list) {
		for (SysDict sysDict : list) {
			sysDict.setDictId(sequenceService.getUpdateQuerySeq("TSD", "t_sys_dict"));
		}
		return sysDictService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<SysDict> list) {
		return sysDictService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<SysDict> list) {
		return sysDictService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById/{id}")
	public JsonResult<SysDict> queryEntityById(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return AppResponseCode.success(sysDictService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return sysDictService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<SysDict> param = new Criteria<SysDict>();
		param.addParam("dictId", id);
		// TODO Auto-generated method stub
		return sysDictService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return sysDictService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

}