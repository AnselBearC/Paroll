/**
 * 功能描述: <br>
 * 〈工资单的控制层$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/14$ 上午 09:00$
 */

package com.ansel.payroll.controller;


import com.ansel.payroll.common.api.CommonPage;
import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyPayroll;
import com.ansel.payroll.service.PayrollService;
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

@Api(tags = "payrollController",description = "工资单管理")
@Controller
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @ApiOperation("获取所有工资列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyPayroll>> getPayrollList() {
        return CommonResult.success(payrollService.listAllPayroll());
    }

    @ApiOperation("添加工资单")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createPayroll(@RequestBody PyPayroll pyPayroll) {
        Date date = new Date();
        pyPayroll.setCreateTime(date);
        CommonResult commonResult;
        int count = payrollService.createPayroll(pyPayroll);
        if(count==1) {
            commonResult = CommonResult.success(pyPayroll);
            LOGGER.debug("createPayroll success:{}",pyPayroll);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createPayroll failed:{}",pyPayroll);
        }
        return commonResult;
    }

    @ApiOperation("更新工资单")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePayroll(@PathVariable("id") Integer id,@RequestBody PyPayroll pyPayroll, BindingResult result) {
        Date date = new Date();
        pyPayroll.setUpdateTime(date);
        CommonResult commonResult;
        int count = payrollService.updatePayroll(id,pyPayroll);
        if(count == 1) {
            commonResult = CommonResult.success(pyPayroll);
            LOGGER.debug("updatePayroll success:{}",pyPayroll);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updatePayroll failed:{}",pyPayroll);
        }
        return commonResult;
    }

    @ApiOperation("删除工资单")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deletePayroll(@PathVariable("id") Integer id) {
        int count = payrollService.deletePayroll(id);
        if(count == 1) {
            LOGGER.debug("deletePayroll success id:{}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deletePayroll failed id:{}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询工资单")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PyPayroll>> listPayroll(@RequestParam(value = "pageNum",defaultValue = "1")
                                                         @ApiParam("页码") Integer pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "3")
                                                         @ApiParam("每页数量") Integer pageSize) {

        List<PyPayroll> listPayroll = payrollService.listPayroll(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(listPayroll));

    }

    @ApiOperation("获取指定id的工资单")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PyPayroll> payroll(@PathVariable("id") Integer id) {
        return CommonResult.success(payrollService.getPayroll(id));
    }

}
