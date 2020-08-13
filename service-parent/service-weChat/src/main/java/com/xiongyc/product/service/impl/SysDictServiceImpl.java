package com.xiongyc.product.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiongyc.cache.RedisUtil;
import com.xiongyc.product.annotation.Dict;
import com.xiongyc.product.bean.SysDict;
import com.xiongyc.product.dao.ISysDictDao;
import com.xiongyc.product.service.ISysDictService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class SysDictServiceImpl implements ISysDictService {

	@Override
	public PageInfo<SysDict> queryPage(Criteria<SysDict> param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		return new PageInfo<SysDict>(sysDictDao.queryPage(param));
	}

	public List<SysDict> queryList(Criteria<SysDict> param) {
		return sysDictDao.queryList(param);
	}

	@Override
	public Integer queryPageCount(Criteria<SysDict> param) {
		return (Integer) sysDictDao.queryPageCount(param);
	}

	@Override
	public SysDict queryEntityById(String id) {
		return sysDictDao.queryEntityById(id);
	}

	@Override
	public String insert(SysDict record) {
		int result = sysDictDao.insert(record);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String insertBatch(List<SysDict> list) {
		int result = sysDictDao.insertBatch(list);
		if (result != list.size()) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String updateByCriteria(Criteria<SysDict> param) {
		int result = sysDictDao.updateByCriteria(param);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String updateBatchByCriteria(List<SysDict> list) {
		int result = sysDictDao.updateBatchByCriteria(list);
		if (result == 0) {
			return AppResponseCode.RESPONSE_CODE_UPDATE_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String insertOrUpdateBatch(List<SysDict> list) {
		int result = sysDictDao.insertOrUpdateBatch(list);
		if (result != list.size()) {
			return AppResponseCode.RESPONSE_CODE_INSERT_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteById(String id) {
		int result = sysDictDao.deleteById(id);
		if (result != 1) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteByCriteria(Criteria<SysDict> param) {
		int result = sysDictDao.deleteByCriteria(param);
		if (result < 1) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public String deleteBatchByIds(String[] ids) {
		int result = sysDictDao.deleteBatchByIds(ids);
		if (result == 0) {
			return AppResponseCode.RESPONSE_CODE_DEL_FALSE.getMessage();
		}
		return null;
	}

	@Override
	public <T> List<Map<String, Object>> translateToMapList(List<T> data) {

		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

		if (data == null || data.isEmpty()) {
			return ret;
		}

		Class<?> rowClazz = data.get(0).getClass();
		Field[] fields = FieldUtils.getAllFields(rowClazz);
		if (fields == null || fields.length < 1) {
			return ret;
		}

		for (Object rowData : data) {
			Map<String, Object> row = translateToMap(rowData);
			if (row != null) {
				ret.add(row);
			}
		}

		return ret;
	}
	
	@Override
	public Map<String, Object> translateToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		Field[] fields = FieldUtils.getAllFields(obj.getClass());
		if (fields == null || fields.length < 1) {
			return null;
		}

		Map<String, Object> row = new HashMap<String, Object>();

		for (int i = 0; i < fields.length; i++) {

			Field aField = fields[i];
			Dict config = aField.getAnnotation(Dict.class);

			String fieldName = aField.getName();
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
			try {
				Object value = MethodUtils.invokeMethod(obj, methodName);
				row.put(fieldName, value);

				if (config != null && !StringUtils.isEmpty(config.dictCode())) {

					if (value == null) {
						row.put(fieldName + "Zh", "");
						continue;
					}

					row.put(fieldName + "Zh", cachedValue(config.dictCode(), value.toString()));
				}

			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug("dict translate fault.", e);
				}
			}
		}
		return row;
	}
	
	public static final String SERVICE_REDIS_COMMON = "REDIS_COMMON";
	
	
	public String cachedValue(String key, String value) {

		String cachedKey = String.format("dictCode=[%s]dictValue=[%s]", key, value);	
		String cachedValue = (String) redisUtil.get("common_"+cachedKey);

		if (null != cachedValue) {
			return cachedValue;
		}

		Criteria<SysDict> param = new Criteria<SysDict>();
		param.initParams().addParam("dictCode", key);
		param.addParam("dictValue", value);

		List<SysDict> tmp = sysDictDao.queryList(param);
		if (tmp != null && !tmp.isEmpty()) {
			cachedValue = tmp.get(0).getDictRemark() != null ? tmp.get(0).getDictRemark() : "";
		} else {
			cachedValue = "";
		}

		if (!StringUtils.isEmpty(cachedValue)) {
			redisUtil.set("common_"+cachedKey, cachedValue);
		}
		return cachedValue;
	}

	@Override
	public List<Map<String, Object>> translateToMapList(List<Map<String, Object>> data, Map<String, String> transColumns) {

		if (data == null || data.isEmpty()) {
			return data;
		}

		if (transColumns == null || transColumns.isEmpty()) {
			return data;
		}

		for (Map<String, Object> row : data) {
			translateToMap(row, transColumns);
		}

		return data;
	}
	
	public Map<String, Object> translateToMap(Map<String, Object> obj, Map<String, String> transColumns) {

		if (obj == null || obj.isEmpty()) {
			return obj;
		}

		if (transColumns == null || transColumns.isEmpty()) {
			return obj;
		}

		for (Entry<String, String> column : transColumns.entrySet()) {
			if (obj.containsKey(column.getKey()) && null != obj.get(column.getKey())) {
				obj.put(column.getKey() + "Zh", cachedValue(column.getValue(), obj.get(column.getKey()).toString()));
			}
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String ,List<SysDict>> queryEntityByDictCode(String... dictCode) {
		Map<String ,List<SysDict>> map = new HashMap<String ,List<SysDict>>(dictCode.length);
		for (String code : dictCode) {
			if(redisUtil.exists(code)) {
				map.put(code, (List<SysDict>)redisUtil.get(code));
			}else {
				Criteria<SysDict> param = new Criteria<SysDict>();
				param.initParams().addParam("dictCode", code);
				List<SysDict> list = sysDictDao.queryList(param);
				redisUtil.set(code, list);
				map.put(code, list);
			}
		}
		return map;
	}

	@Autowired
	private ISysDictDao sysDictDao;

	@Autowired
	private RedisUtil redisUtil;
}
