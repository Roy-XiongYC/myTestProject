//package com.person.web.admin.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.person.framework.constant.MessageConstant;
//import com.person.framework.mybatis.Criteria;
//import com.person.framework.service.IMessageService;
//import com.person.web.admin.model.SysGroupUser;
//import com.person.web.admin.model.SysResource;
//import com.person.web.admin.model.SysUser;
//import com.person.web.admin.repository.ISysGroupUserRepository;
//import com.person.web.admin.repository.ISysResourceRepository;
//import com.person.web.admin.service.ISysDictService;
//import com.person.web.admin.service.ISysResourceService;
//
//public class SysResourceServiceImpl implements ISysResourceService {
//	@Override
//	public List<SysResource> queryAllByUser(SysUser sysUser) {
//		log.info("get userResource start");
//		// 查询用户拥有权限
//		SysGroupUser group = null;
//		String userId = sysUser.getUserId();
//		if (userId != null) {
//			group = groupUserRepository.queryByUserId(sysUser.getUserId());
//		}
//		if (group == null) {
//			return null;
//		}
//		Criteria<SysResource> param = new Criteria<SysResource>();
//		// 测试shiro  可暂时注释
//		param.addParam("groupId", group.getGroupId());
//		param.setOrderBy(" r.resource_id,r.parent_resource_id,r.order_number");
//		return queryPageNoLimit(param);
//	}
//	
//	public List<SysResource> queryPage(Criteria<SysResource> param) {
//		List<SysResource> list = sysResourceRepository.queryPage(param);
//		return list;
//	}
//	
//	public List<SysResource> queryPageNoLimit(Criteria<SysResource> param) {
//		List<SysResource> list = sysResourceRepository.queryPageNoLimit(param);
//		return list;
//	}
//	
//	@Override
//	public List<SysResource> queryAllPage(Criteria<SysResource> param) {
//		List<SysResource> list = sysResourceRepository.queryAllPage(param);
//		return list;
//	}
//	@Override
//	public List<Map<String, Object>> queryPageList(Criteria<SysResource> param) {
//		List<SysResource> list = sysResourceRepository.queryPage(param);
//		return sysDictService.translateToMapList(list);
//	}
//
//	public Integer queryPageCount(Criteria<SysResource> param) {
//		return (Integer) sysResourceRepository.queryPageCount(param);
//	}
//	
//	/**
//	 * 查询所有菜单并对传入用户组验证是否有权限
//	 * @param groupId
//	 * @return
//	 */
//	public List<SysResource> queryByGroup(Criteria<SysResource> param){
//		return sysResourceRepository.queryByGroup(param);
//	}
//
//	public SysResource queryEntityById(String id) {
//		return sysResourceRepository.queryEntityById(id);
//	}
//
//	public String insert(SysResource record) {
//		int result = sysResourceRepository.insert(record);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00010);
//		}
//		return null;
//	}
//
//	public String updateByCriteria(Criteria<SysResource> param) {
//		int result = sysResourceRepository.updateByCriteria(param);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00011);
//		}
//		return null;
//	}
//
//	public String deleteById(String id) {
//		int result = sysResourceRepository.deleteById(id);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00012);
//		}
//		return null;
//	}
//
//	public String deleteByCriteria(Criteria<SysResource> param) {
//		sysResourceRepository.deleteByCriteria(param);
//		return null;
//	}
//
//	public void setSysResourceRepository(ISysResourceRepository repository) {
//		this.sysResourceRepository = repository;
//	}
//
//	public void setMessageService(IMessageService messageService) {
//		this.messageService = messageService;
//	}
//
//	public void setGroupUserRepository(ISysGroupUserRepository groupUserRepository) {
//		this.groupUserRepository = groupUserRepository;
//	}
//
//	public void setSysDictService(ISysDictService sysDictService) {
//		this.sysDictService = sysDictService;
//	}
//
//	private ISysResourceRepository sysResourceRepository;
//	private ISysGroupUserRepository groupUserRepository;
//	private IMessageService messageService;
//	private ISysDictService sysDictService;
//	protected final Logger log = LoggerFactory.getLogger(getClass());
//}
