//package com.person.web.admin.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import com.person.framework.mybatis.Criteria;
//import com.person.web.admin.model.SysGroup;
//import com.person.web.admin.service.ISysDictService;
//import com.person.web.admin.service.ISysGroupService;
//import com.person.web.admin.repository.ISysGroupRepository;
//import com.person.web.blog.service.ISequenceService;
//import com.person.framework.redis.RedisServiceUtil;
//import com.person.framework.service.IMessageService;
//import com.person.framework.utils.StringUtil;
//import com.person.framework.constant.DefaultConstant;
//import com.person.framework.constant.MessageConstant;
//import com.person.framework.constant.RedisConstant;
//
//public class SysGroupServiceImpl implements ISysGroupService {
//
//	public List<SysGroup> queryPage(Criteria<SysGroup> param) {
//		List<SysGroup> list = sysGroupRepository.queryPage(param);
//		return list;
//	}
//	@Override
//	public List<Map<String, Object>> queryPageList(Criteria<SysGroup> param) {
//		List<SysGroup> list = sysGroupRepository.queryPage(param);
//		return sysDictService.translateToMapList(list);
//	}
//	public Integer queryPageCount(Criteria<SysGroup> param) {
//		return (Integer) sysGroupRepository.queryPageCount(param);
//	}
//
//	public SysGroup queryEntityById(String id) {
//		return sysGroupRepository.queryEntityById(id);
//	}
//	@Override
//	public String insertOrUpdate(SysGroup record){
//		String ret = null;
//		//验证是否存在
//		Criteria<SysGroup> param = new Criteria<SysGroup>();
//		param.addParam("groupName", record.getGroupName());
//		List<SysGroup> list = queryPage(param);
//		
//		if (StringUtil.isNullOrBlank(record.getGroupId())) {
//			if (list!=null && list.size()>0) {
//				return messageService.message(MessageConstant.C00001, record.getGroupName());
//			}
//			record.setGroupId(sequenceService.getUpdateQuerySeq(DefaultConstant.SEQ_COMMON));
//			record.setGroupStatus(DefaultConstant.USER_STOP);
//			ret = insert(record);
//		}else {
//			if (list!=null && list.size()>0 && !list.get(0).getGroupId().equals(record.getGroupId())) {
//				return messageService.message(MessageConstant.C00001, record.getGroupName());
//			}
//			param.clearParams().addParam("groupId", record.getGroupId());
//			param.setRecord(record);
//			ret = updateByCriteria(param);
//		}
//		return ret;
//	}
//	
//	public String insert(SysGroup record) {
//		int result = sysGroupRepository.insert(record);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00010);
//		}
//		RedisServiceUtil.delJedis(RedisServiceUtil.SERVICE_REDIS_COMMON, RedisConstant.GROUP_SELECT_NAME);
//		return null;
//	}
//
//	public String updateByCriteria(Criteria<SysGroup> param) {
//		int result = sysGroupRepository.updateByCriteria(param);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00011);
//		}
//		RedisServiceUtil.delJedis(RedisServiceUtil.SERVICE_REDIS_COMMON, RedisConstant.GROUP_SELECT_NAME);
//		return null;
//	}
//
//	public String deleteById(String id) {
//		int result = sysGroupRepository.deleteById(id);
//		if (result != 1) {
//			return messageService.message(MessageConstant.C00012);
//		}
//		RedisServiceUtil.delJedis(RedisServiceUtil.SERVICE_REDIS_COMMON, RedisConstant.GROUP_SELECT_NAME);
//		return null;
//	}
//
//	public String deleteByCriteria(Criteria<SysGroup> param) {
//		sysGroupRepository.deleteByCriteria(param);
//		RedisServiceUtil.delJedis(RedisServiceUtil.SERVICE_REDIS_COMMON, RedisConstant.GROUP_SELECT_NAME);
//		return null;
//	}
//
//	public void setSysGroupRepository(ISysGroupRepository repository) {
//		this.sysGroupRepository = repository;
//	}
//
//	public void setMessageService(IMessageService messageService) {
//		this.messageService = messageService;
//	}
//
//	public void setSysDictService(ISysDictService sysDictService) {
//		this.sysDictService = sysDictService;
//	}
//
//	public void setSequenceService(ISequenceService sequenceService) {
//		this.sequenceService = sequenceService;
//	}
//
//	private ISysGroupRepository sysGroupRepository;
//
//	private IMessageService messageService;
//	
//	private ISysDictService sysDictService;
//	
//	private ISequenceService sequenceService;
//
//}
