package com.xiongyc.product.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

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
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xiongyc.product.bean.PetsClass;
import com.xiongyc.product.bean.ServiceProject;
import com.xiongyc.product.bean.ShopOrder;
import com.xiongyc.product.bean.ShopUser;
import com.xiongyc.product.bean.UserPet;
import com.xiongyc.product.bean.Varieties;
import com.xiongyc.product.service.IPetsClassService;
import com.xiongyc.product.service.IServiceProjectService;
import com.xiongyc.product.service.IShopOrderService;
import com.xiongyc.product.service.IShopUserService;
import com.xiongyc.product.service.IUserPetService;
import com.xiongyc.product.service.IVarietiesService;
import com.xiongyc.sequence.service.SequenceService;
import com.xiongyc.utils.code.AppResponseCode;
import com.xiongyc.utils.mybatis.Criteria;
import com.xiongyc.utils.result.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(description = "商城订单表")
@RequestMapping(value = "/shopOrder")
public class ShopOrderController {

	@Autowired
	private IShopOrderService shopOrderService;

	@Autowired
	private IShopUserService shopUserService;
	
	@Autowired
	private IUserPetService userPetService;

	@Autowired
	private IServiceProjectService serviceProjectService;
	
	@Autowired
	private IVarietiesService varietiesService;
	
	@Autowired
	private IPetsClassService petsClassService;
	
	@Autowired
	private SequenceService sequenceService;

	@ApiOperation(value = "翻页查询列表")
	@GetMapping("/queryPage")
	public JsonResult<PageInfo<ShopOrder>> queryPage(
			@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "userName", value = "用户名称") @RequestParam(required = false) String userName,
			@ApiParam(name = "mobile", value = "联系方式手机号") @RequestParam(required = false) String mobile,
			@ApiParam(name = "orderId", value = "主键ID") @RequestParam(required = false) String orderId,
			@ApiParam(name = "goodsInfo", value = "主键ID") @RequestParam(required = false) String goodsInfo) {
		Criteria<ShopOrder> param = new Criteria<ShopOrder>(pageNum, pageSize);
		if (!StringUtils.isEmpty(orderId)) {
			param.addParam("orderId", orderId);
		}
		if (!StringUtils.isEmpty(mobile)) {
			param.addParam("mobile", mobile);
		}
		if (!StringUtils.isEmpty(userName)) {
			param.addParam("like_userName", userName);
		}
		if (!StringUtils.isEmpty(goodsInfo)) {
			param.addParam("like_goodsInfo", goodsInfo);
		}
		param.setOrderBy("order_id desc");
		return AppResponseCode.success(shopOrderService.queryPage(param));
	}

	
	@ApiOperation(value = "更新状态")
	@GetMapping("/updateStatus/{id}/{status}")
	public JsonResult<Object> updateStatus(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id,
			@ApiParam(name = "status", value = "主键ID") @PathVariable(name = "status") String status) {
		Criteria<ShopOrder> param = new Criteria<ShopOrder>();
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setOrderStatus(status);
		param.addParam("orderId", id);
		param.setRecord(shopOrder);
		return shopOrderService.updateByCriteria(param) == null ? AppResponseCode.success(): AppResponseCode.failure();
	}
	
	@ApiOperation(value = "保存数据")
	@PostMapping("/addOrUpdate")
	public JsonResult<Object> addOrUpdate(@RequestBody ShopOrder shopOrder) {
		
		log.info("=======>" + shopOrder.toString());
		
		String ret = null;
		if (!StringUtils.isEmpty(shopOrder.getOrderId())) {
			Criteria<ShopOrder> param = new Criteria<ShopOrder>();
			param.addParam("orderId", shopOrder.getOrderId());
			param.setRecord(shopOrder);
			ret = shopOrderService.updateByCriteria(param);
		} else {
			//解析商品
			JSONObject jsonObject1 = JSONObject.parseObject(shopOrder.getGoodsInfo());
			
			//查询宠物信息
			String petId = jsonObject1.get("petId").toString();
			UserPet pet = userPetService.queryEntityById(petId);
			
			//查询类型
			PetsClass petsClass = petsClassService.queryEntityById(pet.getPetTypeId());
			
			//查询子类型
			if(jsonObject1.get("petInfo") != null) {
				String classId = String.valueOf(jsonObject1.get("petInfo"));
				jsonObject1.put("petInfo", petsClassService.queryEntityById(classId).getClassName());
			}
			
			//查询品种
			Varieties varieties = varietiesService.queryEntityById(pet.getVarieties());
			
			
			//查询服务项目信息	
			String serviceId = jsonObject1.get("serviceId").toString();
			ServiceProject serviceProject = serviceProjectService.queryEntityById(serviceId);
			
			
			//计算金额
			BigDecimal orderPrice = serviceProject.getPrice();
			if(jsonObject1.get("dayNum") != null) {
				String num = String.valueOf(jsonObject1.get("dayNum"));
				orderPrice = serviceProject.getPrice().multiply(new BigDecimal(num));
			}
			
			shopOrder.setOrderPrice(orderPrice);

			JSONObject jsonPet = appendJson(jsonObject1, pet);	
			jsonPet = appendJson(jsonPet, petsClass);	
			jsonPet = appendJson(jsonPet, varieties);
			jsonPet = appendJson(jsonPet, serviceProject);	
			String json = JSONObject.toJSONString(jsonPet);
				
			ShopUser user = shopUserService.queryEntityById(shopOrder.getUserId());
			shopOrder.setGoodsInfo(json);
			shopOrder.setUserName(user.getNickName());
			shopOrder.setMobile(pet.getMobile());
			shopOrder.setOrderId(sequenceService.getUpdateQuerySeq("TSO", "t_shop_order"));
			shopOrder.setCreateTime(new Date());
			shopOrder.setOrderStatus("60");
			ret = shopOrderService.insert(shopOrder);
		}
		return ret == null ? AppResponseCode.success() : AppResponseCode.failure();
	}


	private JSONObject appendJson(JSONObject jsonObject1, Object pet) {
		JSONObject parseObject = JSONObject.parseObject(JSONObject.toJSONString(pet));
		for (Entry<String, Object> map : jsonObject1.entrySet()) {
			parseObject.put(map.getKey(),map.getValue()); 
		};
		//String jsonPet = JSONObject.toJSONString(pet);
		return parseObject;
	}

	@ApiOperation(value = "批量新增数据")
	@PostMapping("/addBatch")
	public JsonResult<Object> addBatch(@RequestBody List<ShopOrder> list) {
		for (ShopOrder shopOrder : list) {
			shopOrder.setOrderId(sequenceService.getUpdateQuerySeq("TSO", "t_shop_order"));
		}
		return shopOrderService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "批量更新数据")
	@PostMapping("/updateBatchByCriteria")
	public JsonResult<Object> updateBatchByCriteria(@RequestBody List<ShopOrder> list) {
		return shopOrderService.updateBatchByCriteria(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = " 批量保存实体")
	@PostMapping("/insertOrUpdateBatch")
	public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<ShopOrder> list) {
		return shopOrderService.insertOrUpdateBatch(list) == null ? AppResponseCode.success()
				: AppResponseCode.failure();
	}

	@ApiOperation(value = "详情")
	@GetMapping("/queryEntityById/{id}")
	public JsonResult<ShopOrder> queryEntityById(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return AppResponseCode.success(shopOrderService.queryEntityById(id));
	}

	@ApiOperation(value = "根据主键删除")
	@DeleteMapping("/deleteEntityById/{id}")
	public JsonResult<Object> deleteEntityById(
			@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
		return shopOrderService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据model删除")
	@PostMapping("/deleteEntityByCriteria")
	public JsonResult<Object> deleteEntityByCriteria(
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
		Criteria<ShopOrder> param = new Criteria<ShopOrder>();
		param.addParam("orderId", id);
		// TODO Auto-generated method stub
		return shopOrderService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	@ApiOperation(value = "根据主键批量删除")
	@PostMapping("/deleteBatchByIds")
	public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
		return shopOrderService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
	}

	
	public static void main(String[] args) {
		String str = "{\"petId\":\"TUP20200816000000024\",\"serviceId\":\"TSP20200816000000003\",\"pickUp\":\"0\",\"vaccines\":true}";
		JSONObject jsonObject1 = JSONObject.parseObject(str);

		
		
		//计算金额
		BigDecimal orderPrice = BigDecimal.ZERO;
		if(jsonObject1.get("dayNum") != null) {
			String num = String.valueOf(jsonObject1.get("dayNum"));
			orderPrice = orderPrice.multiply(new BigDecimal(num));
		}
	}
}