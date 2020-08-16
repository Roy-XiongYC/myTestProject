package com.xiongyc.product.controller;

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

import com.xiongyc.product.bean.ServiceProject;

import com.xiongyc.product.service.IServiceProjectService;

@RestController
@Api(description = "服务项目")
@RequestMapping(value = "/serviceProject")
public class ServiceProjectController {

	@Autowired
	private IServiceProjectService serviceProjectService;

	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<ServiceProject>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "projectName", value = "主键ID") @RequestParam(required = false) String projectName) {
		Criteria<ServiceProject> param = new Criteria<ServiceProject>(pageNum, pageSize);
		if (!StringUtils.isEmpty(projectName)) {
			param.addParam("like_projectName", projectName);
		}
		param.setOrderBy("service_id desc");
		return AppResponseCode.success(serviceProjectService.queryPage(param));
	}

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryList")
	public JsonResult<List<ServiceProject>> queryList(
			@ApiParam(name = "type", value = "服务类型 10 美容洗澡 20 寄养") @RequestParam(required = false) String type) {
		Criteria<ServiceProject> param = new Criteria<ServiceProject>();
		if (!StringUtils.isEmpty(type)) {
			param.addParam("type", type);
		}
		param.setOrderBy("service_id desc");
		return AppResponseCode.success(serviceProjectService.queryList(param));
	}

	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody ServiceProject serviceProject) {
		String ret = null;
		if (!StringUtils.isEmpty(serviceProject.getServiceId())) {
			Criteria<ServiceProject> param = new Criteria<ServiceProject>();
			param.addParam("serviceId", serviceProject.getServiceId());
			param.setRecord(serviceProject);
			ret = serviceProjectService.updateByCriteria(param);
		} else {
			serviceProject.setServiceId(sequenceService.getUpdateQuerySeq("TSP", "t_service_project"));
			ret = serviceProjectService.insert(serviceProject);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "更新状态")
	@GetMapping("/updateStatus/{id}/{status}")
	public JsonResult<Object> updateStatus(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id,
			@ApiParam(name = "status", value = "主键ID") @PathVariable(name = "status") String status) {
		Criteria<ServiceProject> param = new Criteria<ServiceProject>();
		ServiceProject serviceProject = new ServiceProject();
		serviceProject.setDelStatus(status);
		param.addParam("serviceId", id);
		param.setRecord(serviceProject);
		return serviceProjectService.updateByCriteria(param) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<ServiceProject> list) {
		for (ServiceProject serviceProject : list) {
			serviceProject.setServiceId(sequenceService.getUpdateQuerySeq("TSP", "t_service_project"));
		}
		return serviceProjectService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<ServiceProject> list) {
		return serviceProjectService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<ServiceProject> list) {
		return serviceProjectService.insertOrUpdateBatch(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById/{id}")
	public JsonResult<ServiceProject> queryEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return AppResponseCode.success(serviceProjectService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return serviceProjectService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<ServiceProject> param = new Criteria<ServiceProject>();
		param.addParam("serviceId", id);
		// TODO Auto-generated method stub
		return serviceProjectService.deleteByCriteria(param) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return serviceProjectService.deleteBatchByIds(ids) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

}