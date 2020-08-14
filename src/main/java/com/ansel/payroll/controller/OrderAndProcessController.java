/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/30$ 下午 03:43$
 */

package com.ansel.payroll.controller;

import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyOrderProcessRelation;
import com.ansel.payroll.service.OrderAndProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "OrderAndProcessController",description = "订单工序管理")
@Controller
@RequestMapping("/orderAndProcess")
public class OrderAndProcessController {

    @Autowired
    private OrderAndProcessService orderAndProcessService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderAndProcessController.class);

    @ApiOperation("获取当前订单所有工序")
    @RequestMapping(value = "/list/{orderId}" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyOrderProcessRelation>> getOrderAndProcess(@PathVariable("orderId") Integer orderId) {
        return CommonResult.success(orderAndProcessService.listOrderProcessRelation(orderId));
    }

    @ApiOperation("添加订单所需工序")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createOrderAndProcess(@RequestBody PyOrderProcessRelation pyOrderProcessRelation) {
        int count = orderAndProcessService.creatOrderProcessRelation(pyOrderProcessRelation);
        CommonResult commonResult;
        if(count == 1) {
            LOGGER.debug("createOrderProcessRelation success:{}",pyOrderProcessRelation);
            commonResult = CommonResult.success(pyOrderProcessRelation);
        }else {
            LOGGER.debug("createOrderProcessRelation failed:{}",pyOrderProcessRelation);
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("更新订单工序")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrderAndProcess(@PathVariable("id") Integer id,@RequestBody PyOrderProcessRelation pyOrderProcessRelation) {
        int count = orderAndProcessService.updateOrderProcessRelation(id,pyOrderProcessRelation);
        CommonResult commonResult;
        if(count == 1) {
            LOGGER.debug("updateOrderProcessRelation success:{}",pyOrderProcessRelation);
            commonResult = CommonResult.success(pyOrderProcessRelation);
        }else {
            LOGGER.debug("updateOrderProcessRelation failed:{}",pyOrderProcessRelation);
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("删除订单的工序")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteOrderProcessRelation(@PathVariable("id") Integer id) {
        int count = orderAndProcessService.deleteOrderProcessRelation(id);
        CommonResult commonResult;
        if(count == 1) {
            LOGGER.debug("deleteOrderProcessRelation success: id={}",id);
            commonResult = CommonResult.success(null);
        }else {
            LOGGER.debug("deleteOrderProcessRelation failed: id={}",id);
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("删除订单所有的的工序")
    @RequestMapping(value = "/deleteAll/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteAllOrderProcessRelation(@PathVariable("orderId") Integer orderId) {
        int count = orderAndProcessService.deleteOrderProcessRelationByOrderId(orderId);
        CommonResult commonResult;
        if(count == 1) {
            LOGGER.debug("deleteOrderProcessRelationByOrderId success: orderId={}",orderId);
            commonResult = CommonResult.success(null);
        }else {
            LOGGER.debug("deleteOrderProcessRelationByOrderId failed: orderId={}",orderId);
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }
}
