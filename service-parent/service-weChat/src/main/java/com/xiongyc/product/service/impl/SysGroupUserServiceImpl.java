//package com.person.web.admin.service.impl;
//
//import java.util.List;
//
//import com.person.framework.constant.MessageConstant;
//import com.person.framework.mybatis.Criteria;
//import com.person.framework.service.IMessageService;
//import com.person.web.admin.model.SysGroupUser;
//import com.person.web.admin.repository.ISysGroupUserRepository;
//import com.person.web.admin.service.ISysGroupUserService;
//
//public class SysGroupUserServiceImpl implements ISysGroupUserService {
//
//	public List<SysGroupUser> queryPage(Criteria<SysGroupUser> param) {
//		List<SysGroupUser> list = sysGroupUserRepository.queryPage(param);
//		return list;
//	}
//
//	public Integer queryPageCount(Criteria<SysGroupUser> param) {
//		return (Integer) sysGroupUserRepository.queryPageCount(param);
//	}
//
//	public SysGroupUser queryEntityById(String id) {
//		return sysGroupUserRepository.queryEntityById(id);
//	}
//
//	public String insert(SysGroupUser record) {
//		int result = sysGroupUserRepository.insert(record);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00010);
//		}
//		return null;
//	}
//
//	public String updateByCriteria(Criteria<SysGroupUser> param) {
//		int result = sysGroupUserRepository.updateByCriteria(param);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00011);
//		}
//		return null;
//	}
//
//	public String deleteById(String id) {
//		int result = sysGroupUserRepository.deleteById(id);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00012);
//		}
//		return null;
//	}
//
//	public String deleteByCriteria(Criteria<SysGroupUser> param) {
//		sysGroupUserRepository.deleteByCriteria(param);
//		return null;
//	}
//
//	public void setSysGroupUserRepository(ISysGroupUserRepository repository) {
//		this.sysGroupUserRepository = repository;
//	}
//
//	public void setMessageService(IMessageService messageService) {
//		this.messageService = messageService;
//	}
//
//	private ISysGroupUserRepository sysGroupUserRepository;
//
//	private IMessageService messageService;
//
//}
