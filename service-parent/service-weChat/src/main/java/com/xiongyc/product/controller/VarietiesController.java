package com.xiongyc.product.controller;

import java.util.Date;
import java.util.List;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import com.xiongyc.sequence.service.SequenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.xiongyc.utils.code.AppResponseCode;

import com.xiongyc.product.bean.Varieties;

import com.xiongyc.product.service.IVarietiesService;

@RestController
@Api(description = "品种数据")
@RequestMapping(value = "/varieties")
public class VarietiesController {

	@Autowired
	private IVarietiesService varietiesService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "查询列表")
	@GetMapping("/queryList")
	public JsonResult<List<Varieties>> queryList(
			@ApiParam(name = "classId", value = "主键ID") @RequestParam(required = false) String classId) {
		Criteria<Varieties> param = new Criteria<Varieties>();
		if (!StringUtils.isEmpty(classId)) {
			param.addParam("classId", classId);
		}
		param.setOrderBy("varieties_id desc");
		return AppResponseCode.success(varietiesService.queryList(param));
	}

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<Varieties>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "classId", value = "主键ID") @RequestParam(required = false) String classId,
			@ApiParam(name = "varietiesName", value = "品种名称") @RequestParam(required = false) String varietiesName) {
		Criteria<Varieties> param = new Criteria<Varieties>(pageNum, pageSize);
		if (!StringUtils.isEmpty(varietiesName)) {
			param.addParam("varietiesName", varietiesName);
		}
		if (!StringUtils.isEmpty(classId)) {
			param.addParam("classId", classId);
		}
		param.setOrderBy("varieties_id desc");
		return AppResponseCode.success(varietiesService.queryPage(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody Varieties varieties) {
		String ret = null;
		if (!StringUtils.isEmpty(varieties.getVarietiesId())) {
			Criteria<Varieties> param = new Criteria<Varieties>();
			param.addParam("varietiesId", varieties.getVarietiesId());
			param.setRecord(varieties);
			ret = varietiesService.updateByCriteria(param);
		} else {
			varieties.setVarietiesId(sequenceService.getUpdateQuerySeq("TV", "t_varieties"));
			varieties.setCreateTime(new Date());
			ret = varietiesService.insert(varieties);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<Varieties> list) {
		for (Varieties varieties : list) {
			varieties.setVarietiesId(sequenceService.getUpdateQuerySeq("TV", "t_varieties"));
		}
		return varietiesService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<Varieties> list) {
		return varietiesService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<Varieties> list) {
		return varietiesService.insertOrUpdateBatch(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById/{id}")
	public JsonResult<Varieties> queryEntityById(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return AppResponseCode.success(varietiesService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return varietiesService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<Varieties> param = new Criteria<Varieties>();
		param.addParam("varietiesId", id);
		// TODO Auto-generated method stub
		return varietiesService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return varietiesService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

}