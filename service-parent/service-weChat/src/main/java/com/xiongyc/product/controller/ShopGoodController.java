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

import com.xiongyc.product.bean.ShopGood;


import com.xiongyc.product.service.IShopGoodService;


@RestController
@Api(description = "商城商品表")
@RequestMapping(value = "/shopGood")
public class ShopGoodController{

  @Autowired
  private IShopGoodService  shopGoodService;


@Autowired
private SequenceService sequenceService;


  @ApiOperation(value = "翻页查询列表")
  @GetMapping("/queryPage")
  public JsonResult<PageInfo<ShopGood>> queryPage(@ApiParam(name = "pageNum", value = "页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@ApiParam(name = "pageSize", value = "页面大小") @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id){      Criteria<ShopGood> param = new Criteria<ShopGood>(pageNum,pageSize);
     if (!StringUtils.isEmpty(id)) {
        param.addParam("goodId",id);
     }
     param.setOrderBy("good_id desc");
     return AppResponseCode.success(shopGoodService.queryPage(param)); 
  }



  @ApiOperation(value = "保存数据")
  @PostMapping("/addOrUpdate")
  public JsonResult<Object> addOrUpdate(@RequestBody ShopGood shopGood){ 
     String ret=null;
     if (!StringUtils.isEmpty(shopGood.getGoodId())) {
        Criteria<ShopGood> param = new Criteria<ShopGood>();
        param.addParam("goodId", shopGood.getGoodId());
        param.setRecord(shopGood); 
        ret = shopGoodService.updateByCriteria(param); 
     }else {
        shopGood.setGoodId(sequenceService.getUpdateQuerySeq("TSG", "t_shop_good"));
        ret =shopGoodService.insert(shopGood); 
     } 
     return ret == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "批量新增数据")
  @PostMapping("/addBatch")
  public JsonResult<Object> addBatch(@RequestBody List<ShopGood> list){ 
     for (ShopGood shopGood : list) {
        shopGood.setGoodId(sequenceService.getUpdateQuerySeq("TSG", "t_shop_good"));
     } 
     return shopGoodService.insertBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "批量更新数据")
  @PostMapping("/updateBatchByCriteria")
  public JsonResult<Object> updateBatchByCriteria(@RequestBody List<ShopGood> list){ 
     return shopGoodService.updateBatchByCriteria(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = " 批量保存实体")
  @PostMapping("/insertOrUpdateBatch")
  public JsonResult<Object> insertOrUpdateBatch(@RequestBody List<ShopGood> list){ 
     return shopGoodService.insertOrUpdateBatch(list) == null ? AppResponseCode.success() : AppResponseCode.failure(); 
  }



  @ApiOperation(value = "详情")
  @GetMapping("/queryEntityById")
  public JsonResult<ShopGood> queryEntityById(@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) { 
    return AppResponseCode.success(shopGoodService.queryEntityById(id)); 
  }



  @ApiOperation(value = "根据主键删除")
  @DeleteMapping("/deleteEntityById/{id}")
  public JsonResult<Object> deleteEntityById(@ApiParam(name = "id", value = "主键ID") @PathVariable(name = "id") String id) {
    return shopGoodService.deleteById(id) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }



  @ApiOperation(value = "根据model删除")
  @PostMapping("/deleteEntityByCriteria")
  public JsonResult<Object> deleteEntityByCriteria(@ApiParam(name = "id", value = "主键ID") @RequestParam(required = false) String id) {
     Criteria<ShopGood> param = new Criteria<ShopGood>();
     param.addParam("goodId",id);
     // TODO Auto-generated method stub
     return shopGoodService.deleteByCriteria(param) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }



  @ApiOperation(value = "根据主键批量删除")
  @PostMapping("/deleteBatchByIds")
  public JsonResult<Object> deleteBatchByIds(@ApiParam(name = "ids", value = "主键ID") @RequestParam String[] ids) {
    return shopGoodService.deleteBatchByIds(ids) == null ? AppResponseCode.success() : AppResponseCode.failure();
  }






}