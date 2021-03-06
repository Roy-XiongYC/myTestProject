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
import com.xiongyc.product.bean.PetsClass;
import com.xiongyc.product.service.IPetsClassService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "宠物分类")
@RequestMapping(value = "/petsClass")
public class PetsClassController {

	@Autowired
	private IPetsClassService petsClassService;

	@Autowired
	private SequenceService sequenceService;

//  @ApiOperation(value = "翻页查询列表")
//  @GetMapping("/queryPage")
//  public JsonResult<PageInfo<PetsClass>> queryPage(@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
//			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id){      Criteria<PetsClass> param = new Criteria<PetsClass>(pageNum,pageSize);
//     if (!StringUtils.isEmpty(id)) {
//        param.addParam("classId",id);
//     }
//     param.setOrderBy("class_id desc");
//     return AppResponseCode.success(petsClassService.queryPage(param)); 
//  }

	@ApiOperation(value = "查询列表")
	@GetMapping("/queryList")
	public JsonResult<List<PetsClass>> queryList(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id,
			@ApiParam(name = "parentId", value = "父类ID") @RequestParam(required = false) String parentId
			) {
		Criteria<PetsClass> param = new Criteria<PetsClass>(pageNum, pageSize);
		if (!StringUtils.isEmpty(id)) {
			param.addParam("classId", id);
		}
		if (!StringUtils.isEmpty(parentId)) {
			param.addParam("parentId", parentId);
		}
		param.setOrderBy("class_id desc");
		return AppResponseCode.success(petsClassService.queryList(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody PetsClass petsClass) {
		String ret = null;
		if (!StringUtils.isEmpty(petsClass.getClassId())) {
			Criteria<PetsClass> param = new Criteria<PetsClass>();
			param.addParam("classId", petsClass.getClassId());
			param.setRecord(petsClass);
			ret = petsClassService.updateByCriteria(param);
		} else {
			petsClass.setClassId(sequenceService.getUpdateQuerySeq("TPC", "t_pets_class"));
			petsClass.setCreateTime(new Date());
			ret = petsClassService.insert(petsClass);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

//  @ApiOperation(value = "批量新增数据")
//  @PostMapping("/addBatch")
//  public JsonResult<Object> addBatch(@RequestBody List<PetsClass> list){ 
//     for (PetsClass petsClass : list) {
//        petsClass.setClassId(sequenceService.getUpdateQuerySeq("TPC", "t_pets_class"));
//     } 
//     return petsClassService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
//  }
//
//
//
//  @ApiOperation(value = "批量更新数据")
//  @PostMapping("/updateBatchByCriteria")
//  public JsonResult<Object> updateBatchByCriteria(@RequestBody List<PetsClass> list){ 
//     return petsClassService.updateBatchByCriteria(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
//  }
//
//
//
//  @ApiOperation(value = " 批量保存实体")
//  @PostMapping("/insertOrUpdateBatch")
//  public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<PetsClass> list){ 
//     return petsClassService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
//  }

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById")
	public JsonResult<PetsClass> queryEntityById(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		return AppResponseCode.success(petsClassService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return petsClassService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

//  @ApiOperation(value = "根据model删除")
//  @PostMapping("/deleteEntityByCriteria")
//  public JsonResult<Object> deleteEntityByCriteria(@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
//     Criteria<PetsClass> param = new Criteria<PetsClass>();
//     param.addParam("classId",id);
//     // TODO Auto-generated method stub
//     return petsClassService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
//  }
//
//
//
//  @ApiOperation(value = "根据主键批量删除")
//  @PostMapping("/deleteBatchByIds")
//  public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
//    return petsClassService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
//  }

}