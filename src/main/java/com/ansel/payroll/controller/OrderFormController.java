/**
 * 功能描述: <br>
 * 〈订单控制类$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/12$ 上午 10:47$
 */

package com.ansel.payroll.controller;


import com.ansel.payroll.common.api.CommonPage;
import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyOrderForm;
import com.ansel.payroll.service.OrderFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "orderFormController",description = "订单管理")
@Controller
@RequestMapping("/orderform")
public class OrderFormController {
    @Autowired
    private OrderFormService orderFormService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @ApiOperation("获取所有订单信息")
    @RequestMapping(value = "/listAll" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyOrderForm>> getOrderFormList() {
        return CommonResult.success(orderFormService.listAllOrderForm());
    }

    @ApiOperation("添加订单")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createOrderForm(@RequestBody PyOrderForm pyOrderForm) {
        Date date = new Date();
        pyOrderForm.setCreateTime(date);
        int count = orderFormService.creatOrderForm(pyOrderForm);
        CommonResult commonResult;
            if(count == 1) {
            LOGGER.debug("createOrderForm success:{}",pyOrderForm);
            commonResult = CommonResult.success(pyOrderForm);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createOrderForm failed:{}",pyOrderForm);
        }
        return commonResult;
    }

    @ApiOperation("更新订单")
    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrderForm(@PathVariable("id") Integer id,@RequestBody PyOrderForm pyOrderForm, BindingResult result) {
        Date date = new Date();
        pyOrderForm.setUpdateTime(date);
        CommonResult commonResult;
        int count = orderFormService.updateOrderForm(id,pyOrderForm);
        if(count == 1) {
            commonResult = CommonResult.success(pyOrderForm);
            LOGGER.debug("updateOrderForm success:{}",pyOrderForm);
        }else {
            commonResult = CommonResult.failed("操作失误");
            LOGGER.debug("updateOrderForm Failed:{}",pyOrderForm);
        }
        return commonResult;
    }


    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteOrderForm(@PathVariable("id") Integer id) {
        int count = orderFormService.deleteOrderForm(id);
        if(count == 1) {
            LOGGER.debug("deleteOrderForom success : id={}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deleteOrderForm failed id={}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询订单列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PyOrderForm>> listOrderForm(@RequestParam(value = "pageNum",defaultValue = "1")
                                                                   @ApiParam("页码") Integer pageNum,
                                                               @RequestParam(value = "pageSize",defaultValue = "3")
                                                                   @ApiParam("每页数量") Integer pageSize,
                                                               @RequestParam(value = "company",defaultValue = "" ) String company,
                                                               @RequestParam(value = "styleNumber",defaultValue = "" ) String styleNumber,
                                                               @RequestParam(value = "styleDescription",defaultValue = "" ) String styleDescription,
                                                               @RequestParam(value = "isComplete",defaultValue = "" ) Integer isComplete) {
            if(isComplete==null) {
                List<PyOrderForm> OrderFormList = orderFormService.listOrderForm(pageNum,pageSize);
                return CommonResult.success(CommonPage.restPage(OrderFormList));
            }else{
                List<PyOrderForm> OrderFormList = orderFormService.OrderFormBySearch(pageNum,pageSize,company,styleNumber,styleDescription,isComplete);
                return CommonResult.success(CommonPage.restPage(OrderFormList));
            }


    }




}
