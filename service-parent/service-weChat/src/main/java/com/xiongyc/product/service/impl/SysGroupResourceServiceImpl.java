//package com.person.web.admin.service.impl;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import com.person.framework.constant.DefaultConstant;
//import com.person.framework.constant.MessageConstant;
//import com.person.framework.exception.BizException;
//import com.person.framework.mybatis.Criteria;
//import com.person.framework.service.IFilterChainDefinitionsService;
//import com.person.framework.service.IMessageService;
//import com.person.framework.utils.DateUtil;
//import com.person.framework.utils.SpringContextUtil;
//import com.person.framework.utils.StringUtil;
//import com.person.web.admin.model.SysGroupResource;
//import com.person.web.admin.model.SysResource;
//import com.person.web.admin.repository.ISysGroupResourceRepository;
//import com.person.web.admin.service.ISysGroupResourceService;
//import com.person.web.admin.service.ISysResourceService;
//import com.person.web.blog.service.ISequenceService;
//
//public class SysGroupResourceServiceImpl implements ISysGroupResourceService {
//
//	public List<SysGroupResource> queryPage(Criteria<SysGroupResource> param) {
//		List<SysGroupResource> list = sysGroupResourceRepository
//				.queryPage(param);
//		return list;
//	}
//
//	public Integer queryPageCount(Criteria<SysGroupResource> param) {
//		return (Integer) sysGroupResourceRepository.queryPageCount(param);
//	}
//
//	public SysGroupResource queryEntityById(String id) {
//		return sysGroupResourceRepository.queryEntityById(id);
//	}
//
//	/**
//	 * 配置权限使用
//	 */
//	@Override
//	public void insertResource(String groupId, String resource,String userId) {
//
//		Criteria<SysGroupResource> param = new Criteria<SysGroupResource>();
//		param.addParam("groupId", groupId);
//		// 验证有数据就删除
//		Criteria<SysResource> checkParam = new Criteria<SysResource>();
//		checkParam.addParam("groupId", groupId);
//		List<SysResource> list = resourceService.queryByGroup(checkParam);
//		if (list != null && list.size() > 0) {
//			deleteByCriteria(param);
//		}
//
//		// 所有配置菜单
//		List<SysGroupResource> groupResourceList = new ArrayList<SysGroupResource>();
//		SysGroupResource groupResource = null;
//		List<String> queryList = Arrays.asList(resource.split(","));
//		for (String query : queryList) {
//			groupResource = new SysGroupResource();
//			groupResource.setId(sequenceService.getUpdateQuerySeq(DefaultConstant.SEQ_COMMON));
//			groupResource.setGroupId(groupId);
//			groupResource.setResourceId(query);
//			groupResource.setCreateBy(userId);
//			groupResource.setCreateTime(DateUtil.getCurrentDate());
//			groupResource.setAccessAuth(DefaultConstant.ACCESS_AUTH_2);
//			groupResourceList.add(groupResource);
//		}
//		
//		if (!StringUtil.isNullOrBlank(insertList(groupResourceList))) {
//			throw new BizException();
//		}
//		
//		IFilterChainDefinitionsService chainDefinitionsService = SpringContextUtil.getBean("filterChainDefinitionsService");
//		chainDefinitionsService.updatePermission();
//	}
//	@Override
//	public String insertList(List<SysGroupResource> list) {
//		int result = sysGroupResourceRepository.insertList(list);
//		if (result == 0) {
//			return messageService.message(MessageConstant.C00010);
//		}
//		return null;
//	}
//	
//	public String insert(SysGroupResource record) {
//		int result = sysGroupResourceRepository.insert(record);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00010);
//		}
//		return null;
//	}
//
//	public String updateByCriteria(Criteria<SysGroupResource> param) {
//		int result = sysGroupResourceRepository.updateByCriteria(param);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00011);
//		}
//		return null;
//	}
//
//	public String deleteById(String id) {
//		int result = sysGroupResourceRepository.deleteById(id);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00012);
//		}
//		return null;
//	}
//
//	public String deleteByCriteria(Criteria<SysGroupResource> param) {
//		sysGroupResourceRepository.deleteByCriteria(param);
//		return null;
//	}
//
//	public void setSysGroupResourceRepository(
//			ISysGroupResourceRepository repository) {
//		this.sysGroupResourceRepository = repository;
//	}
//
//	public void setMessageService(IMessageService messageService) {
//		this.messageService = messageService;
//	}
//	public void setResourceService(ISysResourceService resourceService) {
//		this.resourceService = resourceService;
//	}
//
//	public void setSequenceService(ISequenceService sequenceService) {
//		this.sequenceService = sequenceService;
//	}
//	
//	private ISysGroupResourceRepository sysGroupResourceRepository;
//
//	private IMessageService messageService;
//	
//	private ISysResourceService resourceService;
//	
//	private ISequenceService sequenceService;
//}
