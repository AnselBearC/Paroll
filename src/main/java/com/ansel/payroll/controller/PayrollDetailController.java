/**
 * 功能描述: <br>
 * 〈工资单详情Controller$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/15$ 上午 09:40$
 */

package com.ansel.payroll.controller;


import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyPayrollDetail;
import com.ansel.payroll.service.PayrollDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "payrollDetailController",description = "工资单详情")
@Controller
@RequestMapping("/payrollDetail")
public class PayrollDetailController {

    @Autowired
    PayrollDetailService payrollDetailService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @ApiOperation("获取工资单明细")
    @RequestMapping(value = "/list/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyPayrollDetail>> getPayrollDetail(@PathVariable("orderId") Integer orderId) {
        return CommonResult.success(payrollDetailService.listPayrollDetail(orderId));

    }


    @ApiOperation("添加工资单详情")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createPayrollDetail(@RequestBody PyPayrollDetail pyPayrollDetail) {
        Date date = new Date();
        pyPayrollDetail.setCreateTime(date);
        CommonResult commonResult;
        int count = payrollDetailService.createPayrollDetail(pyPayrollDetail);
        if(count == 1) {
            commonResult = CommonResult.success(pyPayrollDetail);
            LOGGER.debug("createPayrollDetail success:{}",pyPayrollDetail);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createPayrollDetail failed:{}",pyPayrollDetail);
        }

        return commonResult;
    }

    @ApiOperation("更新工资单明细")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePayrollDetail(@PathVariable("id") Integer id,@RequestBody  PyPayrollDetail pyPayrollDetail) {
        CommonResult commonResult;
        int count = payrollDetailService.updatePayrollDetail(id,pyPayrollDetail);
        if(count == 1) {
            commonResult = CommonResult.success(pyPayrollDetail);
            LOGGER.debug("updatePayrollDetail success:{}",pyPayrollDetail);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updatePayrollDetail failed:{}",pyPayrollDetail);
        }
        return commonResult;
    }

    @ApiOperation("删除工资明细")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deletePayrollDetail(@PathVariable("id") Integer id) {
        int count = payrollDetailService.deletePayrollDetail(id);
        if(count == 1) {
            LOGGER.debug("deletePayrollDetail success id:{}",id);
            return CommonResult.success(payrollDetailService.deletePayrollDetail(id));
        }else {
            LOGGER.debug("deletePayroll failed id:{}",id);
            return CommonResult.failed("操作失败");
        }

    }
}
