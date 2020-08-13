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

import com.xiongyc.product.bean.ShopOrder;


import com.xiongyc.product.service.IShopOrderService;


@RestController
@Api(description = "商城订单表")
@RequestMapping(value = "/shopOrder")
public class ShopOrderController{

  @Autowired
  private IShopOrderService  shopOrderService;


@Autowired
private SequenceService sequenceService;


  @ApiOperation(value = "翻页查询列表")
  @GetMapping("/queryPage")
  public JsonResult<PageInfo<ShopOrder>> queryPage(@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id){      Criteria<ShopOrder> param = new Criteria<ShopOrder>(pageNum,pageSize);
     if (!StringUtils.isEmpty(id)) {
        param.addParam("orderId",id);
     }
     param.setOrderBy("order_id desc");
     return AppResponseCode.success(shopOrderService.queryPage(param)); 
  }



  @ApiOperation(value = "保存数据")
  @PostMapping("/addOrUpdate")
  public JsonResult<Object> addOrUpdate(@RequestBody ShopOrder shopOrder){ 
     String ret=null;
     if (!StringUtils.isEmpty(shopOrder.getOrderId())) {
        Criteria<ShopOrder> param = new Criteria<ShopOrder>();
        param.addParam("orderId", shopOrder.getOrderId());
        param.setRecord(shopOrder); 
        ret = shopOrderService.updateByCriteria(param); 
     }else {
        shopOrder.setOrderId(sequenceService.getUpdateQuerySeq("TSO", "t_shop_order"));
        ret =shopOrderService.insert(shopOrder); 
     } 
     return ret == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "批量新增数据")
  @PostMapping("/addBatch")
  public JsonResult<Object> addBatch(@RequestBody List<ShopOrder> list){ 
     for (ShopOrder shopOrder : list) {
        shopOrder.setOrderId(sequenceService.getUpdateQuerySeq("TSO", "t_shop_order"));
     } 
     return shopOrderService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "批量更新数据")
  @PostMapping("/updateBatchByCriteria")
  public JsonResult<Object> updateBatchByCriteria(@RequestBody List<ShopOrder> list){ 
     return shopOrderService.updateBatchByCriteria(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = " 批量保存实体")
  @PostMapping("/insertOrUpdateBatch")
  public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<ShopOrder> list){ 
     return shopOrderService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "详情")
  @GetMapping("/queryEntityById")
  public JsonResult<ShopOrder> queryEntityById(@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) { 
    return AppResponseCode.success(shopOrderService.queryEntityById(id)); 
  }



  @ApiOperation(value = "根据主键删除")
  @DeleteMapping("/deleteEntityById/{id}")
  public JsonResult<Object> deleteEntityById(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
    return shopOrderService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }



  @ApiOperation(value = "根据model删除")
  @PostMapping("/deleteEntityByCriteria")
  public JsonResult<Object> deleteEntityByCriteria(@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
     Criteria<ShopOrder> param = new Criteria<ShopOrder>();
     param.addParam("orderId",id);
     // TODO Auto-generated method stub
     return shopOrderService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }



  @ApiOperation(value = "根据主键批量删除")
  @PostMapping("/deleteBatchByIds")
  public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
    return shopOrderService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }






}